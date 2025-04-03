package graphs

class CloneGraph133 {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }
        val visited = mutableMapOf<Node, Node>()
        return cloneRecursively(node, visited)
    }

    private fun cloneRecursively(node: Node, visited: MutableMap<Node, Node>): Node {
        if (visited.containsKey(node)) {
            return visited[node]!!
        }
        val clone = Node(node.`val`)
        visited[node] = clone
        node.neighbors.forEach {
            clone.neighbors.add(cloneRecursively(it!!, visited))
        }
        return clone
    }
}

fun main() {
    val testClass = CloneGraph133()
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    node1.neighbors = arrayListOf(node2, node4)
    node2.neighbors = arrayListOf(node1, node3)
    node3.neighbors = arrayListOf(node2, node4)
    node4.neighbors = arrayListOf(node1, node3)

    val result = testClass.cloneGraph(node1)
    println(result)
}