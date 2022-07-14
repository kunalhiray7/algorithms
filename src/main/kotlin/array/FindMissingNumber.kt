package array

class FindMissingNumber {
    fun findMissing(array: Array<Int>): Int {
        var sum = 0
        for (i in array) {
            sum += i
        }
        val n = array.size + 1
        val expectedSum = ( n * (n + 1) ) / 2
        return expectedSum - sum
    }
}

fun main() {
    println(FindMissingNumber().findMissing(arrayOf(1, 2, 3, 5, 6, 7, 8)))
    println(FindMissingNumber().findMissing(arrayOf(1, 2, 3, 4, 5, 6, 7, 8)))
    println(FindMissingNumber().findMissing(arrayOf(1, 2, 3, 4, 5, 6, 7)))
    println(FindMissingNumber().findMissing(arrayOf(2, 3, 4, 5, 6, 7, 8)))
}
