package array


/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */
class LongestSequence {

    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val numSet = nums.toHashSet()
        var longestStreak = 0

        for (num in numSet) {
            // Only start counting if `num` is the start of a sequence
            if (!numSet.contains(num - 1)) {
                var currentNum = num
                var currentStreak = 1

                while (numSet.contains(currentNum + 1)) {
                    currentNum++
                    currentStreak++
                }

                longestStreak = maxOf(longestStreak, currentStreak)
            }
        }

        return longestStreak
    }
}

fun main() {
    val ls = LongestSequence()
    println(ls.longestConsecutive(intArrayOf(100,4,200,1,3,2)))
    println(ls.longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1)))
}