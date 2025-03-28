package array

/**
 * A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is
 * j - i.
 *
 * Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [6,0,8,2,1,5]
 * Output: 4
 * Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.
 * Example 2:
 *
 * Input: nums = [9,8,1,0,1,9,4,0,4,1]
 * Output: 7
 * Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.
 */
class MaxWidthRam962 {
    fun maxWidthRamp1(nums: IntArray): Int {
        var i = 0
        var j = 1
        var maxWidth = 0

        while (j < nums.size) {
            if(nums[i] <= nums[j]) {
                maxWidth = maxOf(maxWidth, j - i)
            }
            j++
        }

        return maxWidth
    }

    fun maxWidthRampWithStack(nums: IntArray): Int {
        val stack = ArrayDeque<Int>()
        for ((i, num) in nums.withIndex()) {
            if (stack.isEmpty() || nums[stack.first()] > num) {
                stack.addFirst(i)
            }
        }
        if (stack.size == nums.size) return 0
        var width = 0

        for (i in nums.indices.reversed()) {
            while (stack.isNotEmpty() && nums[stack.first()] <= nums[i]) {
                width = maxOf(width, i - stack.removeFirst())
            }
        }
        return width
    }

    fun maxWidthRamp(nums: IntArray): Int = nums
        .withIndex()
        .sortedBy { it.value }
        .map { it.index }
        .fold(nums.count() to 0) { (min, max), i -> minOf(min, i) to maxOf(max, i - min) }
        .second
}

fun main() {
    val testClass = MaxWidthRam962()
    println(testClass.maxWidthRamp(intArrayOf(6,0,8,2,1,5)))
    println(testClass.maxWidthRamp(intArrayOf(9,8,1,0,1,9,4,0,4,1)))
    println(testClass.maxWidthRamp(intArrayOf(2,2,1)))
}
