package strings

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aba"
 * Output: true
 * Example 2:
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 *
 * Input: s = "abc"
 * Output: false
 */
class ValidPalindrome2 {

    fun validPalindrome1(s: String): Boolean {
        val reversed = s.reversed()
        var diff = 0
        if (reversed == s) {
            return true
        }
        for (i in 0..s.length / 2) {
            if (s[i] != reversed[i]) {
                diff++
            }
            if (diff > 1) {
                break
            }
        }
        return diff <= 1
    }

    fun validPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while (l < r) {
            if (s[l] != s[r]) {
                return isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1)
            }

            l++
            r--
        }

        return true
    }

    private fun isPalindrome(s: String, i: Int, j: Int) : Boolean {
        var l = i; var r = j;
        while(l<r) {
            if (s[l++] != s[r--]) return false
        }
        return true
    }
}