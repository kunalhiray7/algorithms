package reverseInteger

import kotlin.math.pow

class ReverseInteger {
    fun reverse(x: Int): Int {
        var negative = false
        var reverse = x.toString().reversed()
        if(x < 0) {
            negative = true
            reverse = reverse.removeSuffix("-")
        }
        val r = if(negative)  0 - reverse.toLong() else reverse.toLong()
        if((-2.0).pow(31.0) > r || (2.0).pow(31.0) < r) {
            return 0
        }

        return r.toInt()
    }
}

fun main() {
    println(ReverseInteger().reverse(123))
    println(ReverseInteger().reverse(-123))
    println(ReverseInteger().reverse(120))
    println(ReverseInteger().reverse(0))
    println(ReverseInteger().reverse(-2147483648))
}
