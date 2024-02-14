import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateFeeVKPay() {

        val userCard = "VK Pay"
        val summaTransaction = 200
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(25.0, result)
    }

    @Test
    fun calculateFeeVKPayLimitDay() {

        val userCard = "VK Pay"
        val summaTransaction = 25000
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(0, result)
    }

    @Test
    fun calculateFeeVKPayLimitMonth() {

        val userCard = "VK Pay"
        val summaTransaction = 50_000
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(0, result)
    }

    @Test
    fun calculateFeeCheckMastercardTill300() {

        val userCard = "Mastercard"
        val summaTransaction = 200
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(21.2, result)
    }

    @Test
    fun calculateFeeCheckMastercardFrom300Till75000() {

        val userCard = "Mastercard"
        val summaTransaction = 60000
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(0.0, result)
    }

    @Test
    fun calculateFeeCheckMastercardFrom75000() {

        val userCard = "Mastercard"
        val summaTransaction = 90000
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(110.0, result)
    }

    @Test
    fun calculateFeeCheckMastercardFrom75000LimitDay() {

        val userCard = "Mastercard"
        val summaTransaction = 90000
        val totalTransactionDay = 100_000
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(0, result)
    }

    @Test
    fun calculateFeeCheckMastercardFrom75000LimitMonth() {

        val userCard = "Mastercard"
        val summaTransaction = 90000
        val totalTransactionDay = 0
        val totalTransactionMonth = 550_000
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(0, result)
    }

    @Test
    fun calculateFeeVisaLess35() {

        val userCard = "Visa"
        val summaTransaction = 2000
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(35.0, result)
    }

    @Test
    fun calculateFeeVisaMore35() {

        val userCard = "Visa"
        val summaTransaction = 20000
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(150.0, result)
    }

    @Test
    fun calculateFeeCheckVisaLimitDay() {

        val userCard = "Visa"
        val summaTransaction = 90000
        val totalTransactionDay = 100_000
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(0, result)
    }

    @Test
    fun calculateFeeCheckVisaLimitMonth() {

        val userCard = "Visa"
        val summaTransaction = 90000
        val totalTransactionDay = 0
        val totalTransactionMonth = 550_000
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(0, result)
    }

    @Test
    fun calculateFeeCheckMaestroTill300() {

        val userCard = "Maestro"
        val summaTransaction = 200
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(21.2, result)
    }

    @Test
    fun calculateFeeCheckMaestroFrom300Till75000() {

        val userCard = "Maestro"
        val summaTransaction = 60000
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(0.0, result)
    }

    @Test
    fun calculateFeeCheckMaestroFrom75000() {

        val userCard = "Maestro"
        val summaTransaction = 90000
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(110.0, result)
    }

    @Test
    fun calculateFeeCheckMaestroFrom75000LimitDay() {

        val userCard = "Maestro"
        val summaTransaction = 90000
        val totalTransactionDay = 100_000
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(0, result)
    }

    @Test
    fun calculateFeeCheckMaestroFrom75000LimitMonth() {

        val userCard = "Maestro"
        val summaTransaction = 90000
        val totalTransactionDay = 0
        val totalTransactionMonth = 550_000
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(0, result)
    }

    @Test
    fun calculateFeeMirLess35() {

        val userCard = "Мир"
        val summaTransaction = 2000
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(35.0, result)
    }

    @Test
    fun calculateFeeMirMore35() {

        val userCard = "Мир"
        val summaTransaction = 20000
        val totalTransactionDay = 0
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(150.0, result)
    }

    @Test
    fun calculateFeeCheckMirLimitDay() {

        val userCard = "Мир"
        val summaTransaction = 90000
        val totalTransactionDay = 100_000
        val totalTransactionMonth = 0
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(0, result)
    }

    @Test
    fun calculateFeeCheckMirLimitMonth() {

        val userCard = "Мир"
        val summaTransaction = 90000
        val totalTransactionDay = 0
        val totalTransactionMonth = 550_000
        val limitDay = 150_000
        val limitMonth = 600_000

        val result = calculateFee(userCard, summaTransaction, totalTransactionDay, totalTransactionMonth, limitDay, limitMonth)

        assertEquals(0, result)
    }
}