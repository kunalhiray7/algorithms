package array

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 */
class MaximumSubarray53 {
    fun maxSubArray(nums: IntArray): Int {
        val prefixSum = IntArray(nums.size)
        var sum = 0
        for(i in nums.indices) {
            sum += nums[i]
            prefixSum[i] = sum
        }
        var min = prefixSum[0]
        var max: Int
        var maxDiff = Int.MIN_VALUE
        for(maxIndex in 1 until prefixSum.size) {
            max = prefixSum[maxIndex]
            if(min < max) {
                maxDiff = maxOf(maxDiff, max - min)
            } else {
                min = max
            }
        }
        return maxOf(maxOf(maxDiff, prefixSum.max()), maxOf(nums.sum(), nums.max()))
    }

    fun maxSubArrayOptimized(nums: IntArray): Int {
        var currentSum = nums[0]
        var maxSum = nums[0]

        for (i in 1 until nums.size) {
            currentSum = maxOf(nums[i], currentSum + nums[i])
            maxSum = maxOf(maxSum, currentSum)
        }

        return maxSum
    }
}

fun main() {
    val test = MaximumSubarray53()
    println(test.maxSubArrayOptimized(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(test.maxSubArrayOptimized(intArrayOf(1)))
    // 5,4,-1,7,8
    // 5,9,8,15,23
    println(test.maxSubArrayOptimized(intArrayOf(5,4,-1,7,8)))
    println(test.maxSubArrayOptimized(intArrayOf(-2,-1)))
    println(test.maxSubArrayOptimized(intArrayOf(1,2,-1)))
}