package array

import java.util.Collections
import java.util.PriorityQueue

/**
 * You are part of a university admissions office and need to keep track of the kth highest test score from applicants in real-time. This helps to determine cut-off marks for interviews and admissions dynamically as new applicants submit their scores.
 *
 * You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and continuously returns the kth highest test score after a new score has been submitted. More specifically, we are looking for the kth highest score in the sorted list of all scores.
 *
 * Implement the KthLargest class:
 *
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
 * int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.
 *
 *
 * Example 1:
 *
 * Input:
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 *
 * Output: [null, 4, 5, 5, 8, 8]
 *
 * Explanation:
 *
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3); // return 4
 * kthLargest.add(5); // return 5
 * kthLargest.add(10); // return 5
 * kthLargest.add(9); // return 8
 * kthLargest.add(4); // return 8
 *
 * Example 2:
 *
 * Input:
 * ["KthLargest", "add", "add", "add", "add"]
 * [[4, [7, 7, 7, 7, 8, 3]], [2], [10], [9], [9]]
 *
 * Output: [null, 7, 7, 7, 8]
 *
 *
 */
class KthLargestElementInStram(val k: Int, nums: IntArray) {
    private val minHeap = PriorityQueue<Int>()

    init {
        nums.forEach { add(it) }
    }

    fun add(`val`: Int): Int {
        if (minHeap.size < k) {
            minHeap.add(`val`)
        } else if (`val` > minHeap.peek()) {
            minHeap.poll()
            minHeap.add(`val`)
        }
        return minHeap.peek()
    }
}

fun main() {
    val kthLargestElementInStram = KthLargestElementInStram(3, intArrayOf(4, 5, 8, 2))
    println(kthLargestElementInStram.add(3))
    println(kthLargestElementInStram.add(5))
    println(kthLargestElementInStram.add(10))
    println(kthLargestElementInStram.add(9))
    println(kthLargestElementInStram.add(4))
}