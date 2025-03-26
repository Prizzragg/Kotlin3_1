fun main() {
    val result = calculateCommission("Maestro", 10000)
    println(result)
}

fun calculateCommission(cardType: String, transferAmount: Int, lastTranslations: Int = 0): Int {
    var commission = 0
    val limitPerDay = 150000
    val monthlyLimit = 600000
    when {
        (transferAmount > limitPerDay) -> {
            println("Превышен лимит по переводу в день!")
        }

        (transferAmount + lastTranslations > monthlyLimit) -> {
            println("Превышен лимит по переводу в месяц!")
        }

        (cardType == "Mastercard" || cardType == "Maestro") -> {
            commission = (transferAmount * 0.006 + 20).toInt()
            println("Для суммы перевода $transferAmount руб. комиссия составит $commission руб.")
        }

        (cardType == "Visa" || cardType == "Мир") -> {
            val minCommission = 35
            commission =
                (if (transferAmount * 0.0075 < minCommission) minCommission else transferAmount * 0.0075).toInt()
            println("Для суммы перевода $transferAmount руб. комиссия составит $commission руб.")
        }

        (cardType == "VK Pay") -> {
            val limitPerDayVK = 15000
            val monthlyLimitVK = 40000
            when {
                (transferAmount > limitPerDayVK) -> println("Превышен лимит по переводу в сутки по счету VK Pay")
                (transferAmount + lastTranslations > monthlyLimitVK) -> println("Превышен лимит по переводу в месяц по счету VK Pay")
                else -> println("Для суммы перевода $transferAmount комиссия по счету VK Pay не взымается")
            }
        }
    }
    return commission
}