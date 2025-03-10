package array

import java.util.PriorityQueue
import java.util.TreeMap

/**
 * Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size
 * groupSize, and consists of groupSize consecutive cards.
 *
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize,
 * return true if she can rearrange the cards, or false otherwise.
 *
 * Example 1:
 *
 * Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * Example 2:
 *
 * Input: hand = [1,2,3,4,5], groupSize = 4
 * Output: false
 * Explanation: Alice's hand can not be rearranged into groups of 4.
 */
class HandOfStraights846 {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) return false

        val countMap = TreeMap<Int, Int>()
        hand.forEach { countMap[it] = countMap.getOrDefault(it, 0) + 1 }

        while (countMap.isNotEmpty()) {
            val firstKey = countMap.firstKey()
            for (i in 0 until groupSize) {
                val currentKey = firstKey + i
                val count = countMap[currentKey] ?: return false
                if (count == 1) {
                    countMap.remove(currentKey)
                } else {
                    countMap[currentKey] = count - 1
                }
            }
        }
        return true
    }
}

fun main() {
    val classToTest = HandOfStraights846()
    println(classToTest.isNStraightHand(intArrayOf(1, 2, 3, 6, 2, 3, 4, 7, 8), 3))
    println(classToTest.isNStraightHand(intArrayOf(1,2,3,4,5), 4))
    println(classToTest.isNStraightHand(intArrayOf(1), 1))
    println(classToTest.isNStraightHand(intArrayOf(1, 2, 3), 1))
    println(classToTest.isNStraightHand(intArrayOf(1, 2, 3), 2))
    println(classToTest.isNStraightHand(intArrayOf(1, 2, 4, 5), 2))
}