package romanNumber

import java.lang.StringBuilder
import java.util.*

class DecimalToRomanConverter {

    private val baseValues = mutableMapOf(1 to "I", 4 to "IV", 5 to "V", 9 to "IX", 10 to "X", 40 to "XL", 50 to "L",
        90 to "XC", 100 to "C", 400 to "CD", 500 to "D", 900 to "CM", 1000 to "M")

    fun intToRoman(num: Int): String {
        var number = num
        val map = TreeMap<Int, String>()
        map[1] = "I"
        map[4] = "IV"
        map[5] = "V"
        map[9] = "IX"
        map[10] = "X"
        map[40] = "XL"
        map[50] = "L"
        map[90] = "XC"
        map[100] = "C"
        map[400] = "CD"
        map[500] = "D"
        map[900] = "CM"
        map[1000] = "M"

        val sb = StringBuilder()
        while (number > 0) {
            val key = map.floorKey(number)
            sb.append(map[key])
            number -= key
        }

        return sb.toString()
    }

    private fun findClosestRomanNumber(num: Int): String? {
        var prevKey = 1
        for(key in baseValues.keys) {
            if(key > num) {
                return baseValues[prevKey]
            }
            prevKey = key
        }
        return baseValues[prevKey]
    }
}

fun main() {
    println(DecimalToRomanConverter().intToRoman(5))
    println(DecimalToRomanConverter().intToRoman(179))
    println(DecimalToRomanConverter().intToRoman(1988))
}
