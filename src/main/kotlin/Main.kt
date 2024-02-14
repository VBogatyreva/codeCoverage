fun main() {
    val fee = calculateFee("Mastercard", 90_000, 0, 0, 150_000, 600_000)

    if (fee == 0) {
        println("Превышен лимит. Операция отклонена.")

    } else {
        println("Перевод выполнен!")
        println("Сумма комиссии: " + fee)
    }
}

fun calculateFee(
    userCard: String,
    summaTransaction: Int,
    totalTransactionDay: Int,
    totalTransactionMonth: Int,
    limitDay: Int,
    limitMonth: Int
): Any {

    println("Перевод в сумме: " + summaTransaction)
    println("Сумма переводов за день: " + totalTransactionDay)
    println("Сумма переводов за месяц: " + totalTransactionMonth)


    var summaFee = when (userCard) {
        "Mastercard" -> {
            if ((totalTransactionMonth + summaTransaction) <= calculateLimitPerCardMax(userCard) && (totalTransactionMonth + summaTransaction) >= calculateLimitPerCardMin(userCard)) 0.00
            else if (calculateLimitPerCardMax(userCard) < (totalTransactionMonth + summaTransaction) && totalTransactionMonth < calculateLimitPerCardMax(userCard)) ((((totalTransactionMonth + summaTransaction - calculateLimitPerCardMax(userCard)) * calculateDiscount(
                discount = userCard
            )) + calculateAddSum(level = userCard)))
            else ((summaTransaction * calculateDiscount(discount = userCard)) + calculateAddSum(level = userCard))
        }

        "Maestro" -> {
            if ((totalTransactionMonth + summaTransaction) <= calculateLimitPerCardMax(userCard) && (totalTransactionMonth + summaTransaction) >= calculateLimitPerCardMin(userCard)) 0.00
            else if (calculateLimitPerCardMax(userCard) < (totalTransactionMonth + summaTransaction) && totalTransactionMonth < calculateLimitPerCardMax(userCard)) ((((totalTransactionMonth + summaTransaction - calculateLimitPerCardMax(userCard)) * calculateDiscount(
                discount = userCard
            )) + calculateAddSum(level = userCard)))
            else ((summaTransaction * calculateDiscount(discount = userCard)) + calculateAddSum(level = userCard))
        }

        "Visa" -> ((((summaTransaction - calculateLimitPerCardMax(limitPerCard = userCard)) * calculateDiscount(discount = userCard) + calculateAddSum(
            level = userCard
        ))))

        "Мир" -> ((((summaTransaction - calculateLimitPerCardMax(limitPerCard = userCard)) * calculateDiscount(discount = userCard) + calculateAddSum(
            level = userCard
        ))))

        "VK Pay" -> (((summaTransaction - calculateLimitPerCardMax(limitPerCard = userCard)) * calculateDiscount(discount = userCard) + calculateAddSum(
            level = userCard
        )))

        else -> 0.00

    }

    var checkLimit = when (userCard) {
        "VK Pay" -> {
            var limitDay = 15_000
            var limitMonth = 40_000
            if ((totalTransactionDay + summaTransaction) <= limitDay && (totalTransactionMonth + summaTransaction) <= limitMonth) summaFee else 0
        }
        else -> if ((totalTransactionDay + summaTransaction) <= limitDay && (totalTransactionMonth + summaTransaction) <= limitMonth) summaFee else 0
    }

    var checkMinFee = when (userCard) {
        "Visa" -> if (summaFee > 35.0) checkLimit else 35.0
        "Мир" -> if (summaFee > 35.0) checkLimit else 35.0
        else -> checkLimit
    }
    return checkMinFee
}


fun calculateLimitPerCardMin (limitPerCard: String): Int {

    var userLimitPerCardMin = when (limitPerCard) {
        "Mastercard" -> 300
        "Maestro" -> 300
        else -> 0
    }
    return userLimitPerCardMin
}

fun calculateLimitPerCardMax (limitPerCard: String): Int {

    var userLimitPerCardMax = when (limitPerCard) {
        "Mastercard" -> 75_000
        "Maestro" -> 75_000
        else -> 0
    }
    return userLimitPerCardMax
}

fun calculateAddSum(level: String): Int {
    var userAddSum = when (level) {
        "Mastercard" -> 20
        "Maestro" -> 20
        else -> 0
    }
    return userAddSum
}

fun calculateDiscount(discount: String): Double {
    var userDiscount = when (discount) {
        "Mastercard" -> 0.006
        "Maestro" -> 0.006
        "Visa" -> 0.0075
        "Мир" -> 0.0075
        "VK Pay" -> 0.00
        else -> 0.00
    }
    return userDiscount
}
