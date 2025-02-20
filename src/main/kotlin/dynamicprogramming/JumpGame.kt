package dynamicprogramming

/**
 * Given an array of integers arr and an integer d. In one step you can jump from index i to index:
 *
 * i + x where: i + x < arr.length and  0 < x <= d.
 * i - x where: i - x >= 0 and  0 < x <= d.
 * In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for all indices k between i and j (More formally min(i, j) < k < max(i, j)).
 *
 * You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.
 *
 * Notice that you can not jump outside of the array at any time.
 */
class JumpGame {
    fun maxJumps(arr: IntArray, d: Int): Int {
        val dp = IntArray(arr.size) { 1 }
        val sortedIndices = arr.indices.sortedBy { arr[it] }
        for (i in sortedIndices) {
            for (j in i - 1 downTo i - d.coerceAtMost(i)) {
                if (j < 0 || arr[j] >= arr[i]) break
                dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
            }
            for (j in i + 1..i + d.coerceAtMost(arr.size - 1 - i)) {
                if (j >= arr.size || arr[j] >= arr[i]) break
                dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
            }
        }
        return dp.maxOrNull()!!
    }

}

fun main() {
    val classToTest = JumpGame()

    println(classToTest.maxJumps(intArrayOf(6,4,14,6,8,13,9,7,10,6,12), 2))
    println(classToTest.maxJumps(intArrayOf(3,3,3,3,3), 3))
    println(classToTest.maxJumps(intArrayOf(7,6,5,4,3,2,1), 1))
    println(classToTest.maxJumps(intArrayOf(7,1,7,1,7,1), 2))
    println(classToTest.maxJumps(intArrayOf(66), 1))
}