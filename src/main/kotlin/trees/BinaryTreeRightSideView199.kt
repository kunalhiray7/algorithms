package trees

import com.sun.source.tree.Tree

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,5,null,4]
 *
 * Output: [1,3,4]
 *
 */
class BinaryTreeRightSideView199 {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        rightViewDfs(root, result, 0)

        return result
    }

    private fun rightViewDfs(root: TreeNode?, result: MutableList<Int>, level: Int) {
        if(root == null) {
            return
        }
        if(level == result.size) {
            result.add(root.`val`)
        }

        rightViewDfs(root.right, result, level + 1)
        rightViewDfs(root.left, result, level + 1)
    }

    private fun rightViewBfs(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val deque = ArrayDeque<TreeNode?>()
        if(root == null) {
            return emptyList()
        }
        deque.addFirst(root)

        while (deque.isNotEmpty()) {
            val size = deque.size
            var rightNode: TreeNode? = null
            repeat(size) {
                val node = deque.removeLastOrNull()
                if(node != null) {
                    rightNode = node
                    deque.addFirst(node.left)
                    deque.addFirst(node.right)
                }
            }
            if(rightNode != null) {
                result.add(rightNode!!.`val`)
            }
        }

        return result
    }
}

fun main() {
    val testClass = BinaryTreeRightSideView199()
    val root = TreeNode(1)
    val left = TreeNode(2)
    root.left = left
    val right = TreeNode(3)
    root.right = right
    left.right = TreeNode(5)
    right.right = TreeNode(4)
    println(testClass.rightSideView(root))
}