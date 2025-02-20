package array

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 *  Example 1:
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * Example 2:
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 */
class DiagonalTraverse {

    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        var step = -1
        var i = 0
        var j = 0
        val result = IntArray(mat.size * mat[0].size)
        var isUp = false

        for(k in 0 until mat.size * mat[0].size) {
            result[k] = mat[i][j]
            // [0, 0], [0, 1], [1, 0], [2, 0], [1, 1], [0, 2], [1, 2], [2, 1], [2, 2]
            // 0, 0, 1, 2, 1, 0, 1, 2, 2
            // 0, 1, 0, 0, 1, 2, 2, 1, 2
            if(isUp) {
                step -= 1
            } else {
                step += 1
            }
            if(step == 0) {
                isUp = false
            }
            if(step == mat.size - 1) {
                isUp = true
            }
            println("$step - $isUp")
        }

        return result
    }

    fun findDiagonalOrderWorking(mat: Array<IntArray>): IntArray {
        val m = mat.size
        val n = mat[0].size
        var index = 0
        val result = IntArray(m * n)
        var up = true
        for (x in 0 until m + n - 1) {
            if (up) {
                up = false
                for (i in x.coerceAtMost(m - 1) downTo 0) {
                    if (x - i >= n) break
                    result[index] = mat[i][x - i]
                    index++
                }
            } else {
                up = true
                for (i in x.coerceAtMost(n - 1) downTo 0) {
                    if (x - i >= m) break
                    result[index] = mat[x - i][i]
                    index++
                }
            }
        }
        return result
    }
}

fun main() {
    val classToTest = DiagonalTraverse()

    println(classToTest.findDiagonalOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))))
    println(classToTest.findDiagonalOrder(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))))
}