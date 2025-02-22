package array

/**
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 */
class MoveZeroes283 {
    fun moveZeroes(nums: IntArray): Unit {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == 0) {
                    val temp = nums[i]
                    nums[i] = nums[j]
                    nums[j] = temp
                }
            }
        }
    }

    fun moveZeroesOptimized(nums: IntArray): Unit {
        var targetZeroIndex = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                val temp = nums[i]
                nums[i] = nums[targetZeroIndex]
                nums[targetZeroIndex] = temp
                targetZeroIndex++
            }
        }
    }
}

fun main() {

    val testClass = MoveZeroes283()
    val nums = intArrayOf(0, 1, 0, 3, 12)
    testClass.moveZeroesOptimized(nums)
    println(nums.contentToString())
    val nums1 = intArrayOf(0, 0, 1)
    testClass.moveZeroesOptimized(nums1)
    println(nums1.contentToString())
}