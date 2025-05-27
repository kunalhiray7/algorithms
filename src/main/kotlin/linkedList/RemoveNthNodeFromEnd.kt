package linkedList

class RemoveNthNodeFromEnd {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var left = head
        var right = head
        repeat(n) {
            right = right?.next
        }
        if (right == null) {
            return head?.next
        }
        while(right?.next != null) {
            left = left?.next
            right = right?.next
        }
        left?.next = left?.next?.next
        return head
    }
}