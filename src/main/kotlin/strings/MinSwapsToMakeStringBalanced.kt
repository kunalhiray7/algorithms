package strings

import java.util.Stack

/**
 * You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
 *
 * A string is called balanced if and only if:
 *
 * It is the empty string, or
 * It can be written as AB, where both A and B are balanced strings, or
 * It can be written as [C], where C is a balanced string.
 * You may swap the brackets at any two indices any number of times.
 *
 * Return the minimum number of swaps to make s balanced.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "][]["
 * Output: 1
 * Explanation: You can make the string balanced by swapping index 0 with index 3.
 * The resulting string is "[[]]".
 * Example 2:
 *
 * Input: s = "]]][[["
 * Output: 2
 * Explanation: You can do the following to make the string balanced:
 * - Swap index 0 with index 4. s = "[]][][".
 * - Swap index 1 with index 5. s = "[[][]]".
 * The resulting string is "[[][]]".
 * Example 3:
 *
 * Input: s = "[]"
 * Output: 0
 * Explanation: The string is already balanced.
 */
class MinSwapsToMakeStringBalanced {

    fun minSwaps(s: String): Int {
        val stack = Stack<Char>()
        s.toCharArray().forEach {
            when (it) {
                '[' -> stack.push(it)
                ']' -> {
                    if (stack.isNotEmpty() && stack.peek() == '[') {
                        stack.pop()
                    } else {
                        stack.push(it)
                    }
                }
            }
        }

        return if (stack.isEmpty()) 0 else stack.size / 2
    }

    fun minSwapsOptimized(s: String): Int {
        var swaps = 0
        var balance = 0
        s.toCharArray().forEach {
            when (it) {
                '[' -> balance++
                ']' -> balance--
            }
            if (balance < 0) {
                swaps++
                balance = 1
            }
        }
        return swaps
    }
}