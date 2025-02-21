package linkedList

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */
class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var result: ListNode? = null
        for (list in lists) {
            result = mergeTwoLists(result, list)
        }
        return result
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return list2
        }

        if (list2 == null) {
            return list1
        }
        val merged = ListNode(list1.`val`)
        var mergedPointer = merged
        var pointer1 = list1
        var pointer2 = list2
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.`val` <= pointer2.`val`) {
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

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

fun main() {
    val mergeSortedLists = MergeKSortedLists()
    val list1 = mergeSortedLists.create(arrayOf(1, 4, 5))
    val list2 = mergeSortedLists.create(arrayOf(1, 3, 4))
    val list3 = mergeSortedLists.create(arrayOf(2, 6))
    val merged = mergeSortedLists.mergeKLists(arrayOf(list1, list2, list3))
    println(merged)
}
