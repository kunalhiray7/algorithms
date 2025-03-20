package strings

/**
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 *
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 *
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 *
 *
 * Example 1:
 *
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 * Example 2:
 *
 * Input: s = "abcde", goal = "abced"
 * Output: false
 */
class RotateString796 {
    fun rotateString(s: String, goal: String): Boolean {
        if(s.length != goal.length) {
            return false
        }

        for(i in 1 until s.length+1) {
            val rotated = s.substring(i, s.length) + s.substring(0, i)
            println(rotated)
            if(rotated == goal) {
                return true
            }
        }
        return false
    }

    fun rotateStringOptimized(s: String, goal: String): Boolean {
        s.forEachIndexed { i, c ->
            if (c == goal[0] && goal == s.substring(i, s.length) + s.substring(0,i)) {
                return true
            }
        }
        return false
    }
}

fun main() {
    val testClass = RotateString796()
    println(testClass.rotateStringOptimized("abcde", "cdeab"))
    println(testClass.rotateStringOptimized("abcde", "abced"))
}