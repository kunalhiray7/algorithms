package array

/**
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the
 * elements in both subsets is equal or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
class PartitionEqualSubsetSum416 {

    fun canPartitionNonRecursive(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 == 1) {
            return false
        }
        val halfSum = sum / 2
        val dp = BooleanArray(halfSum + 1)
        dp[0] = true

        for (num in nums) {
            for (j in halfSum downTo num) {
                dp[j] = dp[j] || dp[j - num]
            }
        }
        return dp[halfSum]
    }

    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 == 1) {
            return false
        }
        val halfSum = sum / 2
        return checkTargetSum(nums, halfSum, 0, 0)
    }

    private fun checkTargetSum(nums: IntArray, halfSum: Int, i: Int, currSum: Int): Boolean {
        if (currSum == halfSum) {
            return true
        }
        if (currSum > halfSum || i >= nums.size) {
            return false
        }
        return checkTargetSum(nums, halfSum, i + 1, currSum + nums[i]) || checkTargetSum(nums, halfSum, i + 1, currSum)
    }
}

fun main() {
    val classToTest = PartitionEqualSubsetSum416()

    println(classToTest.canPartitionNonRecursive(intArrayOf(1, 5, 11, 5)))
    println(classToTest.canPartitionNonRecursive(intArrayOf(1, 2, 3, 5)))
    println(classToTest.canPartitionNonRecursive(intArrayOf(2, 2, 3, 5)))
}