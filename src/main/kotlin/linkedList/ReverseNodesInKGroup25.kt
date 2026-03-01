package linkedList

class ReverseNodesInKGroup25 {
    /**
     * LeetCode 25 — Reverse Nodes in k-Group
     *
     * Given the head of a linked list, reverse the nodes of the list k at a time,
     * and return the modified list. If the number of nodes is not a multiple of k
     * then left-out nodes, in the end, should remain as is.
     *
     * Time:  O(n)    — each node visited and reversed exactly once
     * Space: O(n/k)  — recursion stack depth proportional to number of groups
     */
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        // Guard: verify k nodes exist before reversing
        var count = 0
        var node = head
        while (node != null && count < k) {
            node = node.next
            count++
        }
        if (count < k) return head

        // Reverse exactly k nodes (three-pointer in-place reversal)
        var prev: ListNode? = null
        var curr = head
        repeat(k) {
            val next = curr!!.next
            curr!!.next = prev
            prev = curr
            curr = next
        }

        // head is now the tail of the reversed segment; connect to next group
        head!!.next = reverseKGroup(curr, k)
        return prev
    }
}

fun main() {
    val solution = ReverseNodesInKGroup25()

    // Example 1: [1,2,3,4,5], k=2 → expected [2,1,4,3,5]
    val list1 = ListNode(1).also { a ->
        a.next = ListNode(2).also { b ->
            b.next = ListNode(3).also { c ->
                c.next = ListNode(4).also { d ->
                    d.next = ListNode(5)
                }
            }
        }
    }
    printList(solution.reverseKGroup(list1, 2))

    // Example 2: [1,2,3,4,5], k=3 → expected [3,2,1,4,5]
    val list2 = ListNode(1).also { a ->
        a.next = ListNode(2).also { b ->
            b.next = ListNode(3).also { c ->
                c.next = ListNode(4).also { d ->
                    d.next = ListNode(5)
                }
            }
        }
    }
    printList(solution.reverseKGroup(list2, 3))
}
