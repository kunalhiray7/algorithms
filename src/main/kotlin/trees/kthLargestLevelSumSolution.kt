package trees

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class kthLargestLevelSumSolution {

    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        return 0
    }

    fun breadthFirstSearch(tree: TreeNode?) {
        if (null == tree) {
            return
        }

        val queue = LinkedList<TreeNode>()
        queue.add(tree)

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            println(currentNode.`val`)

            // Add left node first.
            if (currentNode.left != null) {
                queue.add(currentNode.left!!)
            }

            // Add right node next.
            if (currentNode.right != null) {
                queue.add(currentNode.right!!)
            }
        }
    }
}