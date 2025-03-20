package trees

import java.util.*

class SerializeDeserializeBST449 {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()
        bfs(root, sb)

        return "[${sb.removeSuffix(",")}]"
    }

    private fun bfs(root: TreeNode?, sb: StringBuilder) {
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty() && queue.peek() != null) {
            val current = queue.poll()
            sb.append("${current?.`val`},")
            current?.left?.let { queue.add(it) }
            current?.right?.let { queue.add(it) }
        }
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isBlank() || data == "[]") {
            return null
        }
        val nodes = data.removePrefix("[").removeSuffix("]")
        val toCharArray = nodes.split(",")
        val root: TreeNode = TreeNode(toCharArray[0].toInt())
        for (i in 1 until toCharArray.size) {
            val value = toCharArray[i].toInt()
            constructBST(root, value)
        }
        return root
    }

    private fun constructBST(root: TreeNode?, value: Int) {
        if (value <= root?.`val`!!) {
            if (root.left == null) {
                root.left = TreeNode(value)
            } else {
                constructBST(root.left, value)
            }
        } else {
            if (root.right == null) {
                root.right = TreeNode(value)
            } else {
                constructBST(root.right, value)
            }
        }
    }
}

fun main() {
    val ser = SerializeDeserializeBST449()
    val deser = SerializeDeserializeBST449()
    val tree = deser.deserialize("[2,1,3]")
    val treeStr = ser.serialize(tree)
    println(treeStr)
}