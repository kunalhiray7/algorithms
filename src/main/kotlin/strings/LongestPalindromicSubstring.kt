package strings

class LongestPalindromicSubstring {
    /*
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
     */
    // Brute Force
    fun longestPalindromeBruteForce(s: String): String {
        if (isPalindrome(s)) {
            return s
        }
        var longestPalindromicSubstring = ""
        var maxLength = 0
        for (i in s.indices) {
            for (j in i until s.length) {
                val s1 = s.substring(i, j + 1)
                if (isPalindrome(s1) && s1.length > maxLength) {
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
            val subPalindrome = getMaxLengthPalindrome(i, s)
            if (subPalindrome.length > maxLength) {
                longestPalindromicSubstring = subPalindrome
                maxLength = subPalindrome.length
            }
        }

        return longestPalindromicSubstring
    }

    private fun getMaxLengthPalindrome(i: Int, s: String): String {
        val subPalindrome = getPalindrome(i, s)
        val evenSubPalindrome = getEvenPalindrome(i, s)

        return if (subPalindrome.length >= evenSubPalindrome.length) subPalindrome else evenSubPalindrome
    }

    private fun getPalindrome(i: Int, s: String): String {
        var left = i
        var right = i
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left -= 1
            right += 1
        }
        return s.substring(left + 1, right)
    }

    private fun getEvenPalindrome(i: Int, s: String): String {
        var left = i
        var right = i + 1
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left -= 1
            right += 1
        }
        return s.substring(left + 1, right)
    }
}

fun main() {
    println(LongestPalindromicSubstring().longestPalindrome("bb"))
    println(LongestPalindromicSubstring().longestPalindrome("babad"))
    println(LongestPalindromicSubstring().longestPalindrome("cbbd"))
    println(LongestPalindromicSubstring().longestPalindrome("abcd"))
    println(LongestPalindromicSubstring().longestPalindrome("racecar"))
    println(LongestPalindromicSubstring().longestPalindrome("a"))
    println(LongestPalindromicSubstring().longestPalindrome("abb"))
    println(LongestPalindromicSubstring().longestPalindrome("ac"))
    println(
        LongestPalindromicSubstring().longestPalindrome("xaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa"),
    )
}
