package com.algorithm.twosums

class TwoSum {
    fun calculateTwoSum(nums: IntArray, target: Int): IntArray {
        var j = 0
        nums.forEachIndexed { index, i ->
            val toSearch = target - i
            j = index + 1
            while (j < nums.size) {
                if (nums[j] == toSearch) {
                    return intArrayOf(index, j)
                }
                j += 1
            }
        }
        return intArrayOf()
    }

    fun twoSumSinglePass(nums: IntArray, target: Int): IntArray {
        var i = 0
        var j = nums.size - 1
        nums.sort()
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
            i += 1
            j -= 1
        }
        return intArrayOf()
    }
}

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    val result = TwoSum().twoSumSinglePass(nums, target)

    println(result.string())
    println(TwoSum().twoSumSinglePass(intArrayOf(1, 2, -1, -4), 0).string())
}
