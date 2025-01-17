package strings

import java.lang.StringBuilder
import java.util.Stack

/**
 * A string s is called happy if it satisfies the following conditions:
 *
 * s only contains the letters 'a', 'b', and 'c'.
 * s does not contain any of "aaa", "bbb", or "ccc" as a substring.
 * s contains at most a occurrences of the letter 'a'.
 * s contains at most b occurrences of the letter 'b'.
 * s contains at most c occurrences of the letter 'c'.
 * Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * Example 2:
 *
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It is the only correct answer in this case.
 *
 */
class HappyString {

    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val happyString = StringBuilder()

        var aPointer = a
        var bPointer = b
        var cPointer = c
        val aString = "aa"
        val bString = "bb"
        val cString = "cc"
        val stack = Stack<String>()

        while (aPointer > 0 && bPointer > 0 && cPointer > 0) {
            if(aPointer >= 2) {
                if(stack.isEmpty() || (stack.isNotEmpty() && stack.peek() != aString)) {
                    stack.push(aString)
                    happyString.append(aString)
                }
                aPointer -= 2
            }

            if(bPointer >= 2) {
                if(stack.isEmpty() || (stack.isNotEmpty() && stack.peek() != bString)) {
                    stack.push(bString)
                    happyString.append(bString)
                }
                bPointer -= 2
            }

            if(cPointer >= 2) {
                if(stack.isEmpty() || (stack.isNotEmpty() && stack.peek() != cString)) {
                    stack.push(cString)
                    happyString.append(cString)
                }
                cPointer -= 2
            }

            if(aPointer in 1..2) {
                stack.push("a")
                happyString.append("a")
                aPointer = 0
            }
            if(bPointer in 1..2) {
                stack.push("b")
                happyString.append("b")
                bPointer = 0
            }
            if(cPointer in 1..2) {
                stack.push("c")
                happyString.append("c")
                cPointer = 0
            }
        }

        return happyString.toString()
    }
}