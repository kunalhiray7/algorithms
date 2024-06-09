package com.algorithm.strings

class PalindromeNumber {

    fun isPalindrome(x: Int): Boolean {
        return x.toString() == x.toString().reversed()
    }
}

fun main() {
    val palindromeNumber = PalindromeNumber()
    println(palindromeNumber.isPalindrome(121))
    println(palindromeNumber.isPalindrome(-121))
}
