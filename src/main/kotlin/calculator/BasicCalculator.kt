package calculator

import java.util.*

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of
 * [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 */
class BasicCalculator {

    fun calculate(s: String): Int {
        val stack = Stack<Int>()
        var digit = 0
        var action = '+'
        for (i in 0..s.lastIndex) {
            val char = s[i]
            if (char.isDigit()) {
                digit = digit * 10 + char.toInt() - '0'.toInt()
            }

            if ((char.isDigit().not() && char.isWhitespace().not()) || i == s.lastIndex) {
                when (action) {
                    '+' -> stack.add(digit)
                    '-' -> stack.add(-digit)
                    '*' -> stack.add(stack.pop() * digit)
                    '/' -> stack.add(stack.pop() / digit)
                }
                action = char
                digit = 0
            }
        }
        return stack.sum()
    }
}

fun main() {
    val basicCalculator = BasicCalculator()
    println(basicCalculator.calculate("3+2*2"))
    println(basicCalculator.calculate(" 3/2 "))
    println(basicCalculator.calculate(" 3+5 / 2 "))
}