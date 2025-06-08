package trees

class RangeSumBST938 {

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        return rangeSumBst(root, low, high, 0)
    }

    private fun rangeSumBst(root: TreeNode?, low: Int, high: Int, sum: Int): Int {
        if (root == null) {
            return sum
        }
        return if (root.`val` >= low && root.`val` <= high) {
            rangeSumBst(root.left, low, high, sum + root.`val`)
            rangeSumBst(root.right, low, high, sum + root.`val`)
        } else {
            sum
        }
    }
}