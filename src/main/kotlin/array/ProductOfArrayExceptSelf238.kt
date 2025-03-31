package array

class ProductOfArrayExceptSelf238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }
        var prefixProduct = 1
        for (i in nums.indices) {
            result[i] = prefixProduct
            prefixProduct *= nums[i]
        }

        var postfixProduct = 1
        for (i in nums.size - 1 downTo 0) {
            result[i] *= postfixProduct
            postfixProduct *= nums[i]
        }

        return result
    }
}

public fun IntArray.multiplication(): Int {
    var sum: Int = 1
    for (element in this) {
        sum *= if (element == 0) 1 else element
    }
    return sum
}

fun main() {
    val testClass = ProductOfArrayExceptSelf238()
    val result1 = testClass.productExceptSelf(intArrayOf(1,2,3,4))
    printArray(result1)
    val result2 = testClass.productExceptSelf(intArrayOf(-1,1,0,-3,3))
    printArray(result2)
}