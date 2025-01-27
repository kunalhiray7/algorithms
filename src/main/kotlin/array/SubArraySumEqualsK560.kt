package array

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
class SubArraySumEqualsK560 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var prefixSum = 0
        val freqMap = mutableMapOf<Int, Int>()
        var result = 0
        freqMap[0] = 1
        for (n in nums) {
            prefixSum += n
            result += freqMap.getOrDefault(prefixSum - k, 0)
            freqMap[prefixSum] = freqMap.getOrDefault(prefixSum, 0) + 1
        }

        return result
    }
}

fun main() {
    val classToTest = SubArraySumEqualsK560()

    println(classToTest.subarraySum(intArrayOf(1, 1, 1), 2))
    println(classToTest.subarraySum(intArrayOf(1, 2, 3), 3))
}
