package calculator

import java.util.*

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer
 * with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
class PerfectSquares279 {
    fun numSquares(n: Int): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(n, 0))
        val visited = BooleanArray(n + 1)

        while (queue.isNotEmpty()) {
            val (current, steps) = queue.poll()

            var i = 1
            while (i * i <= current) {
                val next = current - i * i
                if (next == 0) {
                    return steps + 1
                }
                if (!visited[next]) {
                    queue.add(Pair(next, steps + 1))
                    visited[next] = true
                }
                i++
            }
        }

        return n
    }
}

fun main() {
    val classToTest = PerfectSquares279()

    // 12, 6
    println(classToTest.numSquares(12))
    println(classToTest.numSquares(13))
}