package array

class RemoveElement27 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[k] = nums[i]
                k += 1
            }
        }
        return k
    }
}

fun main() {
    val testClass = RemoveElement27()
    println(testClass.removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
}
