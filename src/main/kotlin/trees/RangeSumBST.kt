package trees

class RangeSumBST {
//    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
//        return rangeSum(root, low, high, 0)
//    }
//
//    private fun rangeSum(root: TreeNode?, low: Int, high: Int, sum: Int): Int {
//        if(root == null) {
//            return 0
//        }
//        if(root.left != null && root.left?.`val`!! >= low) {
//            return rangeSum(root.left, high, low, sum + root.`val`)
//        }
//        if(root.right != null && root.right?.`val`!! <= high) {
//            return rangeSum(root.right, high, low, sum + root.`val`)
//        }
//        return 0
//    }

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        return rangeSum(root, low, high)
    }

    private fun rangeSum(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) {
            return 0
        }
        return if (root.`val` < low) {
            rangeSum(root.right, low, high)
        } else if (root.`val` > high) {
            rangeSum(root.left, low, high)
        } else {
            root.`val` + rangeSum(root.left, low, high) + rangeSum(root.right, low, high)
        }
    }
}

fun main() {
    val classToTest = RangeSumBST()
    val tree = arrayOfNulls<Int>(11).apply {
        this[0] = 10
        this[1] = 5
        this[2] = 15
        this[3] = 3
        this[4] = 7
        this[5] = null
        this[6] = 18
    }
    println(classToTest.rangeSumBST(buildBinarySearchTree(tree), 7, 15))
}

fun buildBinarySearchTree(tree: Array<Int?>): TreeNode? {
    val nodes = tree.map { it?.let { TreeNode(it) } }
    nodes.forEachIndexed { index, treeNode ->
        if (index * 2 + 1 < nodes.size) {
            treeNode?.left = nodes[index * 2 + 1]
        }
        if (index * 2 + 2 < nodes.size) {
            treeNode?.right = nodes[index * 2 + 2]
        }
    }
    return nodes.first()
}
