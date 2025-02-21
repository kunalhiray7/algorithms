package strings

import java.lang.StringBuilder

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
class LongestCommonPrefix {

    @Suppress("MemberNameEqualsClassName")
    fun longestCommonPrefix1(strs: Array<String>): String {
        val sb = StringBuilder()
        strs.forEach {
            if (it.isBlank()) {
                return ""
            }
            it.toCharArray().forEach { c ->
                sb.append(c.toString())
                if (!it.startsWith(sb.toString())) {
                    return sb.toString()
                }
            }
        }

        return if (strs.last() == sb.toString()) {
            sb.toString()
        } else {
            sb.deleteCharAt(sb.length - 1)
            sb.toString()
        }
    }

    @Suppress("MemberNameEqualsClassName")
    fun longestCommonPrefix(strs: Array<String>): String {
        val maxLengthWord: String = strs.maxByOrNull { it.length } ?: ""
        val sb = StringBuilder()
        for (c in maxLengthWord) {
            strs.forEach {
                if (!it.startsWith(sb.toString() + c)) {
                    return sb.toString()
                }
            }
            sb.append(c)
        }
        return sb.toString()
    }
}

fun main() {
    val longestCommonPrefix = LongestCommonPrefix()
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("flower", "flow", "flight", "flower")))
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("")))
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("flower", "flow", "flight", "flower")))
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("cat", "cow")))
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("coward", "cow")))
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("coward", "", "cow")))
}
