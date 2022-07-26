package romanNumber

class RomanNumberConverter {

    private val baseValues = mapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50, "C" to 100, "D" to 500, "M" to 1000)

    fun romanToInt(s: String): Int {
        var calculatedNumber = 0
        var lastDecimalValue = 0
        for (i in s.length - 1 downTo 0) {
            val currentBaseValue = baseValues[s[i].toString()]!!
            calculatedNumber = executeOperation(currentBaseValue, lastDecimalValue, calculatedNumber)
            lastDecimalValue = currentBaseValue
        }
        return calculatedNumber
    }

    private fun executeOperation(currentDecimalValue: Int, lastDecimalValue: Int, calculatedNumber: Int): Int {
        return if (lastDecimalValue > currentDecimalValue) {
            calculatedNumber - currentDecimalValue
        } else {
            calculatedNumber + currentDecimalValue
        }
    }
}

fun main() {

    println(RomanNumberConverter().romanToInt("III"))
    println(RomanNumberConverter().romanToInt("LVIII"))
    println(RomanNumberConverter().romanToInt("MCMXCIV"))

}
