package linkedList


/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
class ReorderList143 {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) {
            return
        }
        var size = 0
        var root = head
        while (root != null) {
            root = root.next
            size++
        }
        println(size)
        root = head
        var currentPointer = 0
        var halfReversed: ListNode? = null
        var prev: ListNode? = null
        while (root != null) {
            if (currentPointer >= size / 2) {
                println(currentPointer)
                halfReversed = ListNode(root.`val`)
                halfReversed.next = prev
                prev = halfReversed
            }
            root = root.next
            currentPointer++
        }

        var first = head
        var second = halfReversed
        while (second != null) {
            val temp1 = first?.next
            val temp2 = second.next
            first?.next = second
            second.next = temp1
            first = temp1
            second = temp2
        }
        root = head
        var i = 0
        while (i < size - 1) {
            root = root?.next
            i++
        }
        root?.next = null

        println("done")
    }

    fun reorderListOptimized(head: ListNode?) {
        if (head?.next == null) return

        // Step 1: Find the middle of the list
        var slow = head
        var fast = head
        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // Step 2: Reverse the second half of the list
        var prev: ListNode? = null
        var curr = slow?.next
        slow?.next = null
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }

        // Step 3: Merge the two halves
        var first = head
        var second = prev
        while (second != null) {
            val temp1 = first?.next
            val temp2 = second.next
            first?.next = second
            second.next = temp1
            first = temp1
            second = temp2
        }
    }
}

fun main() {
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(3)
    val l4 = ListNode(4)
    val l5 = ListNode(5)
    val l6 = ListNode(6)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    l5.next = l6
    l6.next = null
    val testClass = ReorderList143()
    testClass.reorderListOptimized(l1)
    printList(l1)
}
