package minRemoveToMakeValidParenteses

import java.util.Stack
import kotlin.math.abs

/**
 * A parentheses string is valid if and only if:
 *
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "())"
 * Output: 1
 * Example 2:
 *
 * Input: s = "((("
 * Output: 3
 */
class MinAddToMakeValidParentheses {

    fun minAddToMakeValid(s: String): Int {
        // ()))((
        val chars = s.toCharArray()
        val stack = Stack<Char>()
        var openMissing = 0
        for(c in chars) {
            when(c) {
                '(' -> {
                    stack.push(c)
                }
                ')' -> {
                    if(stack.isNotEmpty()) {
                        stack.pop()
                    } else {
                        openMissing += 1
                    }
                }
            }
        }

        val size = stack.size
        println("size: $size - openMissing: $openMissing")
        return size + openMissing
    }
}