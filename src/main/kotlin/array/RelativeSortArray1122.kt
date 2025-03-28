package array

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that
 * do not appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * Example 2:
 *
 * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * Output: [22,28,8,6,17,44]
 */
class RelativeSortArray1122 {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        var replaceIndex = 0
        arr1.sort()
        arr2.forEachIndexed { index, i ->
            arr1.forEachIndexed { index2, j ->
                if (i == j) {
                    val temp = arr1[replaceIndex]
                    arr1[replaceIndex] = i
                    arr1[index2] = temp
                    replaceIndex++
                }
            }
        }
        return arr1
    }

    fun relativeSortArrayOptimized(arr1: IntArray, arr2: IntArray): IntArray {
        val countMap = IntArray(1001) // Assuming the range of elements is 0 to 1000
        arr1.forEach { countMap[it]++ }

        var index = 0
        arr2.forEach { num ->
            while (countMap[num] > 0) {
                arr1[index++] = num
                countMap[num]--
            }
        }

        for (num in countMap.indices) {
            while (countMap[num] > 0) {
                arr1[index++] = num
                countMap[num]--
            }
        }

        return arr1
    }
}

fun main() {
    val testClass = RelativeSortArray1122()
    val result = testClass.relativeSortArrayOptimized(intArrayOf(28, 6, 22, 8, 44, 17), intArrayOf(22, 28, 8, 6))
    printArray(result)
    val result2 =
        testClass.relativeSortArrayOptimized(intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19), intArrayOf(2, 1, 4, 3, 9, 6))
    printArray(result2)
    val result3 =
        testClass.relativeSortArrayOptimized(intArrayOf(33, 22, 48, 4, 39, 36, 41, 47, 15, 45), intArrayOf(22, 33, 48, 4))
    printArray(result3)
}