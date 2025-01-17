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

    fun twoSumHashMap(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { index, i ->
            if(map.containsKey(target - i)) {
                return intArrayOf(index, map[target - i]!!)
            } else {
                map[i] = index
            }
        }

        return intArrayOf()
    }
}

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    val result = TwoSum().twoSumHashMap(nums, target)

    println(result.string())
    println(TwoSum().twoSumHashMap(intArrayOf(1, 2, -1, -4), 0).string())
    //generate more test cases
    println(TwoSum().twoSumHashMap(intArrayOf(3, 2, 4), 6).string())
    println(TwoSum().twoSumHashMap(intArrayOf(3, 3), 6).string())
    println(TwoSum().twoSumHashMap(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 19).string())
    // generate negative numbers test cases
    println(TwoSum().twoSumHashMap(intArrayOf(-1, -2, -3, -4, -5), -8).string())
    println(TwoSum().twoSumHashMap(intArrayOf(-1, -2, -3, -4, -5), -9).string())
    // generate when sum is not found
    println(TwoSum().twoSumHashMap(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 20).string())
}
