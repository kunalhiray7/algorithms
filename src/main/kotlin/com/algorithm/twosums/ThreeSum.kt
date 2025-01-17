package com.algorithm.twosums

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 */
class ThreeSum {

    private val twoSum = TwoSum()

    fun calculateThreeSum(nums: IntArray): List<List<Int>> {
        val targetTripletSum = 0
        val result = mutableListOf<List<Int>>()

        nums.forEachIndexed { index, n ->
            val subArray = nums.copyOfRange(index + 1, nums.size)
            val newTarget = targetTripletSum - n
            val twoSumResult = twoSum.calculateTwoSum(subArray, newTarget)
            println(
                "$n : subArray: ${subArray.string()}, newTarget: $newTarget, " +
                    "twoSumResult : ${twoSumResult.string()}",
            )
            if (twoSumResult.isNotEmpty()) {
                val tempList = listOf(n, subArray[twoSumResult[0]], subArray[twoSumResult[1]])
                if (!result.contains(tempList)) {
                    result.add(tempList)
                }
            }
        }

        println(result)
        return result
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        for (i in 0 until nums.size - 2) {
            var l = i + 1
            var r = nums.size - 1
            if (i > 0 && nums[i] == nums[i - 1]) continue
            while (l < nums.size -1 && l < r) {
                val sum = nums[i] + nums[l] + nums[r]
                if (sum == 0) {
                    res.add(listOf(nums[i], nums[l++], nums[r--]))
                    while (l < r && nums[l] == nums[l - 1]) l++
                    while (l < r && nums[r] == nums[r + 1]) r--
                } else if (sum > 0) {
                    r--
                } else {
                    l++
                }
            }
        }
        return res
    }
}

fun List<Int>.contains(vararg nums: Int): Boolean {
    return this.containsAll(nums.toList())
}

fun IntArray.string(): String {
    return "[${this.joinToString(", ")}]"
}

fun main() {
    val threeSum = ThreeSum()
    println(threeSum.calculateThreeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
}
