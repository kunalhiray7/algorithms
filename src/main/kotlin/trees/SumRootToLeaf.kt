package trees

import java.lang.StringBuilder

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 */
class SumRootToLeaf {
    fun sumNumbers(root: TreeNode?): Int {
        return sumNumbers(root, 0)
    }

    private fun sumNumbers(root: TreeNode?, currentSum: Int): Int {
        if (root == null) return 0

        val newSum = currentSum * 10 + root.`val`

        if (root.left == null && root.right == null) {
            return newSum
        }

        return sumNumbers(root.left, newSum) + sumNumbers(root.right, newSum)
    }
}

fun main() {
    val classToTest = SumRootToLeaf()
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    node1.left = node2
    node1.right = node3
    println(classToTest.sumNumbers(node1))


    val n1 = TreeNode(4)
    val n2 = TreeNode(9)
    val n3 = TreeNode(5)
    val n4 = TreeNode(0)
    val n5 = TreeNode(1)

    n1.left = n2
    n1.right = n4
    n2.left = n3
    n1.right = n5
    println(classToTest.sumNumbers(n1))
}