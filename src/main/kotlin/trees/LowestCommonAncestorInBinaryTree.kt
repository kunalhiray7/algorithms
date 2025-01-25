package trees

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 *
 */
class LowestCommonAncestorInBinaryTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        if (root == p || root == q) {
            return root
        }
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        if (left != null && right != null) {
            return root
        }
        return left ?: right
    }
}

fun main() {
    val classToTest = LowestCommonAncestorInBinaryTree()
    val tree = arrayOfNulls<Int>(11).apply {
        this[0] = 3
        this[1] = 5
        this[2] = 1
        this[3] = 6
        this[4] = 2
        this[5] = 0
        this[6] = 8
        this[9] = 7
        this[10] = 4
    }
    println(classToTest.lowestCommonAncestor(buildTree(tree), TreeNode(5), TreeNode(1)))
}

fun buildTree(tree: Array<Int?>): TreeNode? {
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