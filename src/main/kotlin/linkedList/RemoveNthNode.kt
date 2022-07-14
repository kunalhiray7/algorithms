package linkedList

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class RemoveNthNode {

    fun removeNthNode(head: ListNode?, n: Int): ListNode? {
        if(head == null || n == 0) {
            return head
        }

        if(n == 1) {
            return head.next
        }

        var prev: ListNode? = null
        var current: ListNode? = head
        var i = 1
        while (current?.next != null && i != n) {
            i += 1
            prev = current
            current = current.next
        }

        if(prev != null) {
            prev.next = current?.next
        }

        return head
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var pointer = head
        var node = head
        var prev: ListNode? = null
        var next: ListNode? = null
        if (n <= 0) {
            return head
        }
        var size = 0
        var counter = n
        while (pointer != null) {
            size++
            if (counter > 0) {
                counter--
            } else if (counter == 0) {
                prev = node
                node = node?.next
                next = node?.next
            }
            pointer = pointer.next
        }
        return when {
            size == n -> {
                head!!.next
            }
            prev != null -> {
                prev.next = next
                head
            }
            n == 1 -> {
                null
            }
            else -> {
                null
            }
        }
    }

    fun create(array: Array<Int>): ListNode {
        val root = ListNode(array[0])
        var current = root
        for (i in 1 until array.size) {
            val node = ListNode(array[i])
            current.next = node
            current = current.next!!
        }

        return root
    }
}

fun main() {
    val removeNthNode = RemoveNthNode()
    val list = removeNthNode.create(arrayOf(5, 6, 7, 10, 11))
    val updatedList = removeNthNode.removeNthNode(list,1)
    println(updatedList)
}
