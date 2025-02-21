package numbers

import java.util.PriorityQueue
import kotlin.math.min
import kotlin.math.pow

/**
 * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
 *
 * Return the maximum valued number you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 *
 * Input: num = 9973
 * Output: 9973
 * Explanation: No swap.
 */
class MaximumSwap670 {

    fun maximumSwap(num: Int): Int {
        if (num < 12) return num
        val str = num.toString()
        var left = 0
        var right = 1
        var swapIndex = -1
        while (left < right) {
            if (str[left] < str[right]) {
                if (swapIndex == -1) {
                    swapIndex = right
                } else if (str[swapIndex] <= str[right]) {
                    swapIndex = right
                }
            }
            if (right < str.length - 1) {
                right++
            } else {
                if (swapIndex == -1) {
                    left++
                    right = min(left + 1, str.length - 1)
                } else {
                    break
                }
            }
        }
        return if (swapIndex == -1) num
        else {
            (str.substring(0, left) + str[swapIndex] + str.substring(left + 1, swapIndex) + str[left] + str.substring(
                swapIndex + 1,
                str.length
            ))
                .toInt()
        }
    }

    fun maximumSwapWithPriorityQueue(num: Int): Int {
        val digits = num.toString().toCharArray()
        val lastIndex = IntArray(10) { -1 }

        // Store the last occurrence of each digit
        for (i in digits.indices) {
            lastIndex[digits[i] - '0'] = i
        }

        // Find the first smaller digit that can be swapped with a larger digit appearing later
        for (i in digits.indices) {
            for (d in 9 downTo (digits[i] - '0' + 1)) {
                if (lastIndex[d] > i) {
                    // Swap
                    val temp = digits[i]
                    digits[i] = digits[lastIndex[d]]
                    digits[lastIndex[d]] = temp
                    return String(digits).toInt()
                }
            }
        }

        return num
    }
}

fun main() {
    val classToTest = MaximumSwap670()

    println(classToTest.maximumSwapWithPriorityQueue(2736))
    println(classToTest.maximumSwapWithPriorityQueue(9973))
    println(classToTest.maximumSwapWithPriorityQueue(120))
}