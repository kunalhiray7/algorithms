package array

/**
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 */
class FindPeakElementSolution {

    fun findPeakElement(nums: IntArray): Int {
        if(nums.size <= 2) {
            return nums.indexOfLast { it == nums.maxOrNull() }
        }
        var l = 0
        var r = nums.size - 1

        while (l < r) {
            val m = l + (r - l) / 2
            println("l: $l, r: $r, m: $m")
            when {
                m != 0 && m != nums.size - 1 && nums[m] > nums[m - 1] && nums[m] > nums[m + 1] -> {
                    return m
                }
                m != nums.size - 1 && nums[m] < nums[m + 1] -> {
                    l = m + 1
                }
                m != 0 && nums[m] < nums[m - 1] -> {
                    r = m - 1
                }
                else -> {
                    return m
                }
            }
        }

        return nums.indexOfLast { it == nums.maxOrNull() }
    }
}

fun main() {
    val findPeakElementSolution = FindPeakElementSolution()
    println(findPeakElementSolution.findPeakElement(intArrayOf(1, 2, 3, 1)))
    println(findPeakElementSolution.findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
    // generate more test cases
    println(findPeakElementSolution.findPeakElement(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    println(findPeakElementSolution.findPeakElement(intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)))
    println(findPeakElementSolution.findPeakElement(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)))
    // with negative numbers
    println(findPeakElementSolution.findPeakElement(intArrayOf(-1, -2, -3, -1)))
    println(findPeakElementSolution.findPeakElement(intArrayOf(-1, -2, -1, -3, -5, -6, -4)))
    println(findPeakElementSolution.findPeakElement(intArrayOf(-1, -3, -2, -4, -5, -6, -4)))
    println(findPeakElementSolution.findPeakElement(intArrayOf(2,1)))
    println(findPeakElementSolution.findPeakElement(intArrayOf(3,4,3,2,1)))
    println(findPeakElementSolution.findPeakElement(intArrayOf(5,4,3,2,1)))
}
