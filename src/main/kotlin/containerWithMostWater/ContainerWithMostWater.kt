package containerWithMostWater

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 */
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxVolume = 0
        while (left < right) {
            val volume = (right - left) * minOf(height[left], height[right])
            maxVolume = maxOf(maxVolume, volume)
            if (height[left] <= height[right]) {
                left += 1
            } else {
                right -= 1
            }
        }

        return maxVolume
    }
}

fun main() {
    val classToTest = ContainerWithMostWater()

    println(classToTest.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(classToTest.maxArea(intArrayOf(1, 1)))
}
