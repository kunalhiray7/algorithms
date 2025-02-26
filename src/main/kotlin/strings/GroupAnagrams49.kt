package strings

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 */
class GroupAnagrams49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<Int, MutableList<String>>()
        strs.forEach {
            val hash = it.computeTotalHash()
            val value = map.getOrDefault(hash, mutableListOf())
            value.add(it)
            map[hash] = value
        }
        return map.map { it.value }
    }
}

private fun String.computeTotalHash(): Int {
    val chars = this.toCharArray()
    chars.sort()
    return chars.contentToString().hashCode()
}

fun main() {
    val testClass = GroupAnagrams49()
    val result = testClass.groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
    result.map { println(it.toString()) }
}