package array

import java.util.TreeMap

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
class KthLargestElementInArray {

    fun findKthLargest(nums: IntArray, k: Int): Int {
        val sortedMap = TreeMap<Int, Int>()
        nums.forEach { i ->
            val oldVal = sortedMap.getOrElse(i) { 0 }
            sortedMap[i] = oldVal + 1
        }
        var i = nums.size - k + 1
        var result = -1
        while (i > 0) {
            val currentEntry = sortedMap.firstEntry()
            repeat(currentEntry.value) { i-- }
            result = currentEntry.key
            sortedMap.remove(currentEntry.key)
        }

        return result
    }
}

fun main() {
    val kthLargestElementInArray = KthLargestElementInArray()
    println(kthLargestElementInArray.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    println(kthLargestElementInArray.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
}