package calculator

import kotlin.math.abs

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * Constraints:
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 */
class PowerOfNumber50 {

    val memo = mutableMapOf<Pair<Double, Int>, Double>()

    fun myPow1(x: Double, n: Int): Double {
        val power = power(x, abs(n))
        memo[x to abs(n)] = power
        return if(n < 0) 1 / power else power
    }

    // Does not work for large inputs
    private fun power(x: Double, n: Int): Double {
        if(memo[x to n] != null) {
            return memo[x to n]!!
        }
        if(n <= 0) {
            return 1.0
        }
        return x * power(x, n - 1)
    }

    fun myPow(x: Double, n: Int): Double {
        return binaryExp(x, n.toLong())
    }

    private fun binaryExp(x: Double, n: Long): Double {
        if (n == 0L) {
            return 1.0
        }

        if (n < 0) {
            return 1.0 / binaryExp(x, -n)
        }

        return if (n % 2 == 1L) {
            x * binaryExp(x * x, (n - 1) / 2)
        } else {
            binaryExp(x * x, n / 2)
        }
    }
}

fun main() {
    val classToTest = PowerOfNumber50()
    println(classToTest.myPow(2.0, 3))
    println(classToTest.myPow(2.0, -2))
}