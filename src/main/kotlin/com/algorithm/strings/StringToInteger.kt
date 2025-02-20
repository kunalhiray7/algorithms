package com.algorithm.strings

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 *
 * Example 1:
 *
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 * Example 2:
 *
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -42" ("42" is read in)
 *                ^
 * The parsed integer is -42.
 * Since -42 is in the range [-231, 231 - 1], the final result is -42.
 * Example 3:
 *
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 *              ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 *
 */
class StringToInteger {
    fun myAtoi1(s: String): Int {
        var result = 0
        val chars = s.toCharArray()
        var sign = true
        var prevNumber = 0
        if (s.contains("+") && s.contains("-")) {
            return result
        }
        var foundDigit = false
        chars.forEachIndexed { index, c ->
            if (c == '-') {
                if (foundDigit) {
                    return result
                }
                sign = false
            } else if (c == '+') {
                if (foundDigit) {
                    return result
                }
                sign = true
            } else if (c.isDigit()) {
                foundDigit = true
                val d = Integer.parseInt(c.toString())
                val i: Long = prevNumber * 10L
                if (i > Int.MAX_VALUE) {
                    return if (sign) Int.MAX_VALUE else Int.MIN_VALUE
                }
                result = i.toInt() + d
                prevNumber = result
            } else if (c == ' ') {
                if (result != 0) {
                    return getResult(sign, result)
                }
            } else {
                return getResult(sign, result)
            }
        }

        return getResult(sign, result)
    }

    private fun getResult(sign: Boolean, result: Int) = if (sign) result else result * -1

    @OptIn(ExperimentalStdlibApi::class)
    fun myAtoi(s: String): Int {
        var result = 0
        var i = 0

        while (i < s.length && s[i] == ' ') i++

        var positive = true
        if (i != s.length && (s[i] == '+' || s[i] == '-')) {
            positive = s[i] == '+'
            i++
        }

        while (i < s.length && s[i].isDigit()) {
            val digit = s[i++].digitToInt()

            result = if (positive) {
                if (result > (Int.MAX_VALUE - digit) / 10) return Int.MAX_VALUE
                result * 10 + digit
            } else {
                if (result < (Int.MIN_VALUE + digit) / 10) return Int.MIN_VALUE
                result * 10 - digit
            }
        }

        return result
    }
}

fun main() {
    val stringToInteger = StringToInteger()
    println(stringToInteger.myAtoi("42"))
    println(stringToInteger.myAtoi("   -42"))
    println(stringToInteger.myAtoi("4193 with words"))
    println(stringToInteger.myAtoi(" 42  "))
    println(stringToInteger.myAtoi("   -42"))
    println(stringToInteger.myAtoi("abcdefg 4193 with words"))
    println(stringToInteger.myAtoi("abcdefg 419-3 with words"))
    println(stringToInteger.myAtoi("abcdefg - 419-3 with words"))
    println(stringToInteger.myAtoi("words and 987"))
    println(stringToInteger.myAtoi("-91283472332"))
    println(stringToInteger.myAtoi("-+12"))
    println(stringToInteger.myAtoi("+-12"))
    println(stringToInteger.myAtoi("00000-42a1234"))
    println(stringToInteger.myAtoi("  -0012a42"))
}
