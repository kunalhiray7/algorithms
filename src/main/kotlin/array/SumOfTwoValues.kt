package array

import java.util.*


/*
Given an array of integers and a value, determine if there are any two integers in the array whose sum is equal to
the given value. Return true if the sum exists and return false if it does not.
 */
class SumOfTwoValues {

    fun sumOfTwoValues(array: Array<Int>, sum: Int): Boolean {
        for (i in array.indices) {
            val remainder = sum - array[i]
            for (j in i+1 until array.size) {
                if (remainder == array[j])
                    return true
            }
        }
        return false
    }

    fun findSumOfTwo(A: Array<Int>, sum: Int): Boolean {
        val foundValues: MutableSet<Int> = HashSet()
        for (a in A) {
            if (foundValues.contains(sum - a)) {
                return true
            }
            foundValues.add(a)
        }
        return false
    }
}

fun main() {
    val sumOfTwoValues = SumOfTwoValues()
    println(sumOfTwoValues.sumOfTwoValues(arrayOf(5, 7, 1, 2, 8, 4, 3), 10))
    println(sumOfTwoValues.sumOfTwoValues(arrayOf(5, 7, 1, 2, 8, 4, 3), 19))
    println(sumOfTwoValues.sumOfTwoValues(arrayOf(5, 7, 1, 2, 8, 4, 3), 8))
    println(sumOfTwoValues.sumOfTwoValues(arrayOf(5, 7, 1, 2, 8, 4, 3), 9))
    println(sumOfTwoValues.sumOfTwoValues(arrayOf(5, 7, 1, 2, 8, 4, 3), 4))
    println(sumOfTwoValues.sumOfTwoValues(arrayOf(5, 7, 1, 2, 8, 4, 3), 2))
}
