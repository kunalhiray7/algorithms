package linkedList

class ReverseLinkedList206 {
    fun reverseList(head: ListNode?): ListNode? {
        var reversed: ListNode? = null
        var root = head
        var prevNew: ListNode? = null
        while (root != null) {
            reversed = ListNode(root.`val`)
            reversed.next = prevNew
            prevNew = reversed
            root = root.next
        }

        return reversed
    }
}

fun printList(node: ListNode?) {
    var root = node
    while (root != null) {
        println(root.`val`)
        root = root.next
    }
}

fun main() {
    val testClass = ReverseLinkedList206()
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(3)
    val n4 = ListNode(4)
    val n5 = ListNode(5)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next = null
    val reversed = testClass.reverseList(n1)
    printList(reversed)
}