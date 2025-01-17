package array

import java.io.Serializable

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 */
class SearchInRotatedSortedArray {

    fun searchWorking(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while(l <= r) {
            val m = l + (r - l) / 2

            if (nums[m] == target) return m

            if (nums[m] <= nums[r]) {
                if (target > nums[m] && target <= nums[r]) l = m + 1
                else r = m - 1
            } else {
                if (target < nums[m] && target >= nums[l]) r = m - 1
                else l = m + 1
            }
        }
        return -1
    }

    fun search(nums: IntArray, target: Int): Int {
        val sortedArray = getSortedArray(nums)
        sortedArray.first.printElements()
        val binarySearch = binarySearch(sortedArray.first, target)
        if(sortedArray.second == 0) return binarySearch

        return if (binarySearch != -1) (sortedArray.second + binarySearch + 1) % nums.size else -1
    }

    private fun getSortedArray(rotatedSortedArray: IntArray): Pair<IntArray, Int> {
        var left = 0
        var right = rotatedSortedArray.size - 1
        if (rotatedSortedArray[left] <= rotatedSortedArray[right] || rotatedSortedArray.isEmpty()) {
            return Pair(rotatedSortedArray, 0)
        }
        var mid = (left + right) / 2
        while (rotatedSortedArray[left] > rotatedSortedArray[right]) {
            mid = (left + right) / 2
            if (rotatedSortedArray[mid] > rotatedSortedArray[left]) {
                left = mid
            } else {
                right = mid
            }
        }
        return Pair(rotatedSortedArray.copyOfRange(mid + 1, rotatedSortedArray.size).plus(rotatedSortedArray.copyOfRange(0, mid + 1)), mid)
    }

    fun binarySearch(sortedArray: IntArray, target: Int): Int {
        var low: Int = 0
        var high: Int = sortedArray.size - 1

        while (low <= high) {
            val mid = low + high ushr 1
            val midVal: Int = sortedArray[mid]
            if (midVal < target) low = mid + 1 else if (midVal > target) high = mid - 1 else return mid // key found
        }
        return -1
    }
}

fun IntArray.printElements() {
    val sb = StringBuilder()
    sb.append("[ ")
    this.forEach { sb.append("$it, ") }
    sb.append("\b\b ]")
    println(sb.toString())
}