package array

/**
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,0,-2,-3,1], k = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * Example 2:
 *
 * Input: nums = [5], k = 9
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * 2 <= k <= 104
 */
class SubarraysSumsDivisibleByK {

    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val result = mutableListOf<IntArray>()

        for (i in 0 until nums.size) {
            if (nums[i] % k == 0) {
                result.add(intArrayOf(nums[i]))
            }
            for (j in i + 1 until nums.size) {
                if (getSum(nums.sliceArray(i..j)) % k == 0) {
                    result.add(intArrayOf(nums[i]))
                }
            }
        }

        return result.size
    }

    private fun getSum(subarray: IntArray): Int {
        return subarray.sum()
    }
}

fun main() {
    val o = SubarraysSumsDivisibleByK()

    println(o.subarraysDivByK(intArrayOf(4, 5, 0, -2, -3, 1), 5))
}
