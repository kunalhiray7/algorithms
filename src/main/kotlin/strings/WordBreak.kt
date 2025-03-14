package strings

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 */
class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return wordBreakHelper(s, wordDict.toSet())
    }

    private fun wordBreakHelper(s: String, wordDict: Set<String>): Boolean {
        if (s.isEmpty()) {
            return true
        }
        for (word in wordDict) {
            if (s.startsWith(word)) {
                if (wordBreakHelper(s.substring(word.length), wordDict)) {
                    return true
                }
            }
        }
        return false
    }

    fun wordBreakV2(s: String, wordDict: List<String>): Boolean {

        val cache = mutableMapOf<String, Boolean>()

        fun canBeMade(s: String): Boolean {
            if (s.isEmpty()) return true

            cache[s]?.let { return it }
            return wordDict.filter { s.startsWith(it) }.any {
                canBeMade(s.removePrefix(it))
            }.also {
                cache[s] = it
            }
        }
        return canBeMade(s)

    }
}

fun main() {
    val testClass = WordBreak()
    println(testClass.wordBreakV2("leetcode", listOf("leet", "code")))
    println(testClass.wordBreakV2("applepenapple", listOf("apple", "pen")))
    println(testClass.wordBreakV2("catsandog", listOf("cats", "dog", "sand", "and", "cat")))
    println(testClass.wordBreakV2("cars", listOf("car", "ca", "rs")))
}