package strings

class LongestPalindromicSubstring {
    /*
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
     */
    // Brute Force
    fun longestPalindrome1(s: String): String {
        if(isPalindrome(s)) {
            return s
        }
        var longestPalindromicSubstring = ""
        var maxLength = 0
        for(i in s.indices) {
            for(j in i until s.length) {
                val s1 = s.substring(i, j+1)
                if(isPalindrome(s1) && s1.length > maxLength) {
                    maxLength = s1.length
                    longestPalindromicSubstring = s1
                }
            }
        }

        return longestPalindromicSubstring
    }

    private fun isPalindrome(s: String) = s == s.reversed()

    fun longestPalindrome(s: String): String {
        var longestPalindromicSubstring = ""
        var maxLength = 0
        for (i in s.indices) {
            val subPalindrome = getPalindrome(i, s)
            if(subPalindrome.length > maxLength) {
                longestPalindromicSubstring = subPalindrome
                maxLength = subPalindrome.length
            }
        }

        return longestPalindromicSubstring
    }

    private fun getPalindrome(i: Int, s:String): String {
        var left = i
        var right = i
        while(left >= 0 && right < s.length && s[left] == s[right]) {
            left -= 1
            right +=1
        }
        return s.substring(left + 1, right)
    }

}

fun main() {
    println(LongestPalindromicSubstring().longestPalindrome("babad"))
    println(LongestPalindromicSubstring().longestPalindrome("cbbd"))
    println(LongestPalindromicSubstring().longestPalindrome("abcd"))
    println(LongestPalindromicSubstring().longestPalindrome("racecar"))
    println(LongestPalindromicSubstring().longestPalindrome("a"))
    println(LongestPalindromicSubstring().longestPalindrome("abb"))
    println(LongestPalindromicSubstring().longestPalindrome("ac"))
}
