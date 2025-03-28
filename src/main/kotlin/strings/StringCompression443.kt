package strings

import java.lang.StringBuilder

/**
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
 * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 *
 * After you are done modifying the input array, return the new length of the array.
 *
 * You must write an algorithm that uses only constant extra space.
 * Example 1:
 *
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 * Example 2:
 *
 * Input: chars = ["a"]
 * Output: Return 1, and the first character of the input array should be: ["a"]
 * Explanation: The only group is "a", which remains uncompressed since it's a single character.
 * Example 3:
 *
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 */
class StringCompression443 {
    fun compress(chars: CharArray): Int {
        val freqMap = mutableMapOf<Char, Int>()
        chars.forEach { freqMap[it] = freqMap.getOrDefault(it, 0) + 1 }
        val sb = StringBuilder()
        var firstChar = chars[0]
        sb.append(firstChar).also {
            if (freqMap.getOrDefault(firstChar, 0) > 1) {
                sb.append(freqMap.getOrDefault(firstChar, 0))
            }
        }
        chars.forEach { c ->
            if (c != firstChar) {
                sb.append(c).also {
                    if (freqMap.getOrDefault(c, 0) > 1) {
                        sb.append(freqMap.getOrDefault(c, 0))
                    }
                }
                firstChar = c
            }
        }
        println(sb.toString())
        return sb.length
    }

    fun compressWithInlineChange(chars: CharArray): Int {
        if (chars.isEmpty()) {
            return 0
        }
        var charCount = 1
        var i = 0
        var current = 0
        while (current < chars.size) {
            while (current < chars.size - 1 && chars[current] == chars[current + 1]) {
                charCount++
                current++
            }
            if (charCount > 1) {
                chars[i] = chars[current]
                var j = i + 1
                val digits = charCount.toString().toCharArray()
                digits.forEach {
                    chars[j] = it
                    j++
                }
                i = j
            }
            charCount = 1
            current++
        }

        return chars.size
    }

    fun compress1(chars: CharArray): Int {
        var index = 0
        var i = 0

        while (i < chars.size){
            var curChar = chars[i]
            var count = 0

            while (i < chars.size && chars[i] == curChar){
                count++
                i++
            }
            chars[index] = curChar
            index++
            if (count > 1){
                count.toString().forEach { i ->
                    chars[index] = i
                    index++
                }
            }
        }
        return index
    }

    fun swap(chars: CharArray, i: Int, j: Int) {
        val temp = chars[i]
        chars[i] = chars[j]
        chars[j] = temp
    }

}

fun main() {
    val testClass = StringCompression443()
    println(testClass.compress1(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')))
    println(testClass.compressWithInlineChange(charArrayOf('a')))
    println(
        testClass.compressWithInlineChange(
            charArrayOf(
                'a',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b'
            )
        )
    )
}
