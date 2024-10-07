package minRemoveToMakeValidParenteses

import java.util.*

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting
 * parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 */
class MinRemoveToMakeValidParentheses {

    fun minRemoveToMakeValid(s: String): String {
        val stack = Stack<Pair<Char, Int>>()
        val indicesToRemove = mutableListOf<Int>()
        s.toCharArray().mapIndexed { index, c ->
            when (c) {
                '(' -> stack.push(Pair(c, index))
                ')' -> {
                    if (!stack.isEmpty()) {
                        stack.pop()
                    } else {
                        indicesToRemove.add(index)
                    }
                }

                else -> {}
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                val pop = stack.pop()
                indicesToRemove.add(pop.second)
            }
        }
        val finalChars = StringBuilder()
        s.toCharArray().mapIndexed { index, c ->
            if (!indicesToRemove.contains(index)) {
                finalChars.append(c)
            }
        }
        return finalChars.toString().ifEmpty {
            ""
        }
    }
}

fun main() {
    val toTest = MinRemoveToMakeValidParentheses()
    println(toTest.minRemoveToMakeValid("lee(t(c)o)de)"))
    println(toTest.minRemoveToMakeValid("a)b(c)d"))
    println(toTest.minRemoveToMakeValid("))(("))
}
