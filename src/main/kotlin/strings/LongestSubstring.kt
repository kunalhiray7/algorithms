package strings

class LongestSubstring {

    fun lengthOfLongestSubstring(s: String): Int {
        if(s.isEmpty()) {
            return 0
        }
        var maxLength = Int.MIN_VALUE
        val set = mutableSetOf<Char>()
        for (c in s.toCharArray()) {
            val added = set.add(c)
            if(added) {

            } else {
                if(maxLength < set.size) {
                    maxLength = set.size
                }
                set.clear()
                set.add(c)
            }
        }
        return  if (maxLength < set.size) set.size else maxLength
    }

    fun lengthOfLongestSubstring1(s: String): Int {
        val chars = IntArray(128)

        var left = 0
        var right = 0

        var res = 0
        while (right < s.length) {
            val r: Char = s[right]
            chars[r.code]++
            while (chars[r.code] > 1) {
                val l: Char = s[left]
                chars[l.code]--
                left++
            }
            res = res.coerceAtLeast(right - left + 1)
            right++
        }
        return res
    }
}

fun main() {
    println(LongestSubstring().lengthOfLongestSubstring1(" "))
    println(LongestSubstring().lengthOfLongestSubstring1("abcabcbb"))
    println(LongestSubstring().lengthOfLongestSubstring1("pwwkew"))
    println(LongestSubstring().lengthOfLongestSubstring1("bbbb"))
    println(LongestSubstring().lengthOfLongestSubstring1("aab"))
    println(LongestSubstring().lengthOfLongestSubstring1("dvdf"))
}
