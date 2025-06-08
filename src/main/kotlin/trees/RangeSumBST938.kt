package trees

class RangeSumBST938 {

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) {
            return 0
        }
        val sum = when (root.`val` in low..high) {
            true -> root.`val`
            else -> 0
        }

        return sum + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
    }
}
