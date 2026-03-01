package trees

class HouseRobber337 {

    fun rob(root: TreeNode?): Int {
        val (robCurrent, skipCurrent) = dfs(root)
        return maxOf(robCurrent, skipCurrent)
    }

    // Returns Pair(maxIfRobbedHere, maxIfSkippedHere)
    private fun dfs(node: TreeNode?): Pair<Int, Int> {
        if (node == null) return Pair(0, 0)

        val (leftRob, leftSkip) = dfs(node.left)
        val (rightRob, rightSkip) = dfs(node.right)

        val robCurrent = node.`val` + leftSkip + rightSkip
        val skipCurrent = maxOf(leftRob, leftSkip) + maxOf(rightRob, rightSkip)

        return Pair(robCurrent, skipCurrent)
    }
}
