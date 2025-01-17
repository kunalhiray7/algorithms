package array

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 */
class FindFirstAndLastPositionOfElementInSortedArray {

    fun searchRange(nums: IntArray, target: Int): IntArray {
        return findFirstPosition(nums, target)
    }

    private fun findFirstPosition(nums: IntArray, target: Int) : IntArray {
        var left = 0
        var right = nums.size - 1
        if(nums.isEmpty()) return IntArray(2) { -1 }

        while(left <= right) {
            val mid = left + (right - left) / 2
            if(nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
            if(nums[mid] == target) {
                return findMinAndMax(nums, target, mid)
            }

            if(left == right && nums[left] != target) {
                return IntArray(2) { -1 }
            }
        }

        return IntArray(2) { -1 }
    }

    private fun findMinAndMax(nums: IntArray, target: Int, mid: Int): IntArray {
        var left = mid
        var right = mid
        while(left >= 0 && nums[left] == target) {
            left--
        }
        while(right < nums.size && nums[right] == target) {
            right++
        }
        return intArrayOf(left + 1, right - 1)
    }
}