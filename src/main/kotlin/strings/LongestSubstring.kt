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

    fun lengthOfLongestSubstringMap(s: String): Int {
        var max = 0
        val charToIndexMap = mutableMapOf<Char, Int>()
        var left = 0
        var right = 0
        while (right < s.length) {
            val current = s[right]
            if(charToIndexMap.contains(current) && charToIndexMap[current]!! >= left) {
                left = charToIndexMap[current]!! + 1
            }
            max = maxOf(max, right - left + 1)
            charToIndexMap[current] = right
            right++
        }

        return max
    }
}

fun main() {
    println(LongestSubstring().lengthOfLongestSubstringMap(" ")) // 1
    println(LongestSubstring().lengthOfLongestSubstringMap("abcabcbb")) // 3
    println(LongestSubstring().lengthOfLongestSubstringMap("pwwkew")) // 3
    println(LongestSubstring().lengthOfLongestSubstringMap("bbbb")) // 1
    println(LongestSubstring().lengthOfLongestSubstringMap("aab")) // 2
    println(LongestSubstring().lengthOfLongestSubstringMap("dvdf")) // 3
}
