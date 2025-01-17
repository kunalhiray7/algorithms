package containerWithMostWater

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
class TrappingRainWater {

    fun trap(height: IntArray): Int {
        val maxLefts = IntArray(height.size)
        val maxRights = IntArray(height.size)
        var maxLeft = height[0]
        var maxRight = height[height.size - 1]
        // 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        // 0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3 - maxLefts
        // 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 1 - maxRights
        // 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1 - min of maxL and maxR
        // 0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0 - minMaxLMaxR[i] - height[i]
//        height.forEachIndexed { index, i ->
//            maxLefts[index] = maxLeft
//            if(i > maxLeft) {
//                maxLeft = i
//            }
//        }
        var i = 0
        var j = height.size - 1
        while (i < height.size && j >= 0) {
            maxLefts[i] = maxLeft
            if(height[i] > maxLeft) {
                maxLeft = height[i]
            }
            maxRights[j] = maxRight
            if(height[j] > maxRight) {
                maxRight = height[j]
            }
            j--
            i++
        }
        var totalWater = 0
        height.forEachIndexed { index, i ->
            val minOfMaxLAndMaxR = minOf(maxLefts[index], maxRights[index])
            val waterUnit = if(minOfMaxLAndMaxR - i >= 0) {
                minOfMaxLAndMaxR - i
            } else 0
            totalWater += waterUnit
        }

        return totalWater
    }

    fun trapOptimized(height: IntArray): Int {
        var totalWater = 0
        if (height.size <= 1) return totalWater
        var l = 0
        var r = height.size - 1
        var maxLeft = height[l]
        var maxRight = height[r]
        // 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        while (l <= r) {
            if (maxLeft < maxRight) {
                maxLeft = maxOf(maxLeft, height[l])
                totalWater += maxLeft - height[l]
                l++
            } else {
                maxRight = maxOf(maxRight, height[r])
                totalWater += maxRight - height[r]
                r--
            }
        }

        return totalWater
    }
}

fun main() {
    val classToTest = TrappingRainWater()

    println(classToTest.trapOptimized(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(classToTest.trapOptimized(intArrayOf(4, 2, 0, 3, 2, 5)))
}