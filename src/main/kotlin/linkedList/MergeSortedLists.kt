package linkedList

class MergeSortedLists {

    fun merge(list1: Node?, list2: Node?): Node? {
        if(list1 == null) {
            return list2
        }

        if(list2 == null) {
            return list1
        }
        val merged = Node()
        var mergedPointer = merged
        var pointer1 = list1
        var pointer2 = list2
        while (pointer1 != null && pointer2 != null) {
            if(pointer1.data <= pointer2.data) {
                mergedPointer.next = pointer1
                pointer1 = pointer1.next
            } else {
                mergedPointer.next = pointer2
                pointer2 = pointer2.next
            }
            mergedPointer = mergedPointer.next!!
        }

        if (pointer1 != null) {
            mergedPointer.next = pointer1
        }

        if (pointer2 != null) {
            mergedPointer.next = pointer2
        }

        return merged.next
    }

    fun create(array: Array<Int>): Node {
        val root = Node()
        root.data = array[0]
        var current = root
        for (i in 1 until array.size) {
            val node = Node()
            node.data = array[i]
            current.next = node
            current = current.next!!
        }

        return root
    }
}

fun main() {
    val mergeSortedLists = MergeSortedLists()
    val list1 = mergeSortedLists.create(arrayOf(1, 2, 4, 7, 9))
    val list2 = mergeSortedLists.create(arrayOf(5, 6, 7, 10, 11))
    val merged = mergeSortedLists.merge(list1, list2)
    println(merged)
}
