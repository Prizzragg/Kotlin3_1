import org.junit.Assert.assertEquals
import org.junit.Test

class Kotlin3_1KtTest {

    @Test
    fun calculate_Commission_Mastercard() {
        val cardType = "Mastercard"
        val transferAmount = 10000
        val lastTranslations = 0
        val result = calculateCommission(cardType, transferAmount, lastTranslations)
        assertEquals(80, result)
    }

    @Test
    fun calculate_Commission_Maestro() {
        val cardType = "Maestro"
        val transferAmount = 5000
        val lastTranslations = 0
        val result = calculateCommission(cardType, transferAmount, lastTranslations)
        assertEquals(50, result)
    }

    @Test
    fun calculateCommissionVisa() {
        val cardType = "Visa"
        val transferAmount = 10000
        val lastTranslations = 0
        val result = calculateCommission(cardType, transferAmount, lastTranslations)
        assertEquals(75, result)
    }

    @Test
    fun calculateCommissionMir() {
        val cardType = "Мир"
        val transferAmount = 8000
        val lastTranslations = 0
        val result = calculateCommission(cardType, transferAmount, lastTranslations)
        assertEquals(60, result)
    }

    @Test
    fun calculateCommissionVisaMin() {
        val cardType = "Мир"
        val transferAmount = 2000
        val lastTranslations = 0
        val result = calculateCommission(cardType, transferAmount, lastTranslations)
        assertEquals(35, result)
    }

    @Test
    fun calculateCommissionMirMin() {
        val cardType = "Мир"
        val transferAmount = 4000
        val lastTranslations = 0
        val result = calculateCommission(cardType, transferAmount, lastTranslations)
        assertEquals(35, result)
    }

    @Test
    fun calculateCommissionVKPay() {
        val cardType = "VK Pay"
        val transferAmount = 14000
        val lastTranslations = 0
        val result = calculateCommission(cardType, transferAmount, lastTranslations)
        assertEquals(0, result)
    }

    @Test
    fun calculateCommissionExcessMonthLimit() {
        val cardType = "Visa"
        val transferAmount = 10000
        val lastTranslations = 595000
        val result = calculateCommission(cardType, transferAmount, lastTranslations)
        assertEquals(0, result)
    }

    @Test
    fun calculateCommissionExcessLimitPerDay() {
        val cardType = "Mastercard"
        val transferAmount = 200000
        val lastTranslations = 0
        val result = calculateCommission(cardType, transferAmount, lastTranslations)
        assertEquals(0, result)
    }
}