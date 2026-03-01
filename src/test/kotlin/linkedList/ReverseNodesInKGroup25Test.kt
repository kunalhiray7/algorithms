package linkedList

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ReverseNodesInKGroup25Test {

    private val solution = ReverseNodesInKGroup25()

    private fun create(arr: IntArray): ListNode? {
        if (arr.isEmpty()) return null
        val root = ListNode(arr[0])
        var current = root
        for (i in 1 until arr.size) {
            current.next = ListNode(arr[i])
            current = current.next!!
        }
        return root
    }

    private fun toIntArray(head: ListNode?): IntArray {
        val result = mutableListOf<Int>()
        var node = head
        while (node != null) {
            result.add(node.`val`)
            node = node.next
        }
        return result.toIntArray()
    }

    @Test
    fun testExample1_k2() {
        val head = create(intArrayOf(1, 2, 3, 4, 5))
        val result = solution.reverseKGroup(head, 2)
        assertArrayEquals(intArrayOf(2, 1, 4, 3, 5), toIntArray(result))
    }

    @Test
    fun testExample2_k3() {
        val head = create(intArrayOf(1, 2, 3, 4, 5))
        val result = solution.reverseKGroup(head, 3)
        assertArrayEquals(intArrayOf(3, 2, 1, 4, 5), toIntArray(result))
    }

    @Test
    fun testKEqualsLength() {
        val head = create(intArrayOf(1, 2, 3))
        val result = solution.reverseKGroup(head, 3)
        assertArrayEquals(intArrayOf(3, 2, 1), toIntArray(result))
    }

    @Test
    fun testKEqualsOne() {
        val head = create(intArrayOf(1, 2, 3, 4))
        val result = solution.reverseKGroup(head, 1)
        assertArrayEquals(intArrayOf(1, 2, 3, 4), toIntArray(result))
    }

    @Test
    fun testListShorterThanK() {
        val head = create(intArrayOf(1, 2))
        val result = solution.reverseKGroup(head, 5)
        assertArrayEquals(intArrayOf(1, 2), toIntArray(result))
    }

    @Test
    fun testNullHead() {
        val result = solution.reverseKGroup(null, 2)
        assertNull(result)
    }

    @Test
    fun testSingleNode() {
        val head = create(intArrayOf(42))
        val result = solution.reverseKGroup(head, 1)
        assertArrayEquals(intArrayOf(42), toIntArray(result))
    }
}
