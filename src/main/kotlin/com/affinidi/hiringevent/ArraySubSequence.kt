package com.affinidi.hiringevent

class ArraySubSequence {
    fun isValidSequence(array: List<Int>, sequence: List<Int>): Boolean {
        var i = 0
        var j = 0
        while (i < array.size && j < sequence.size) {
            if(sequence[j] == array[i]) {
                j++
            }
            i++
        }

        if(j == sequence.size) {
            return true
        }

        return false
    }
}

fun main() {
    println(ArraySubSequence().isValidSequence(listOf(1, 2, 3, 4), listOf(1, 3, 4)))
    println(ArraySubSequence().isValidSequence(listOf(1, 2, 3, 4), listOf(1, 4)))
    println(ArraySubSequence().isValidSequence(listOf(1, 2, 3, 4), listOf(3, 2)))
    println(ArraySubSequence().isValidSequence(listOf(1, 2, 3, 2, 4, 3), listOf(3, 2)))
    println(ArraySubSequence().isValidSequence(listOf(1, 2, 3, 2, 4, 3), listOf(3, 2, 2)))
    println(ArraySubSequence().isValidSequence(listOf(1, 2, 3, 2, 4, 3), listOf(2, 3, 3)))
}

// array = [1, 2, 3, 4]
// sequence = [1, 3, 4]
