package array

import kotlin.math.abs
import kotlin.math.max

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
        var maxValue = 0
        val set = nums.toSet()
        for (num in nums) {

            if (num - 1 !in set) // Previous not in set means this is first sequence
            {
                var length = 1  // We can create it outside of condition but by doing wasting memory
                while (set.contains(num + length)) {  // Use length not num
                    length += 1
                }
                maxValue = maxOf(maxValue, length)
            }

        }

        return maxValue
    }
}

fun main() {
    val ls = LongestSequence()
    println(ls.longestConsecutive(intArrayOf(100,4,200,1,3,2)))
    println(ls.longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1)))
}