package romanNumber

class RomanNumberConverter {

    private val baseValues = mapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50, "C" to 100, "D" to 500, "M" to 1000)

    fun romanToInt(s: String): Int {
        var value = 0
        var lastNumber = 0
        for (i in s.length - 1 downTo 0) {
            val currentBaseValue = baseValues[s[i].toString()]!!
            value = executeOperation(currentBaseValue, lastNumber, value)
            lastNumber = currentBaseValue
        }
        return value
    }

    private fun executeOperation(decimal: Int, lastNumber: Int, lastDecimal: Int): Int {
        return if (lastNumber > decimal) {
            lastDecimal - decimal
        } else {
            lastDecimal + decimal
        }
    }
}

fun main() {

    println(RomanNumberConverter().romanToInt("III"))
    println(RomanNumberConverter().romanToInt("LVIII"))
    println(RomanNumberConverter().romanToInt("MCMXCIV"))

}
