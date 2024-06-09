package trees

import java.util.*

/*
Given the root of a binary tree, display the node values at each level. Node values for all levels should be displayed on separate lines.
 */

class Node {
    var data: Int = 0
    var left: Node? = null
    var right: Node? = null
}

class LevelWiseDisplay {

    fun displayLevel(tree: Node?) {
        if (null == tree) {
            return
        }
        println(tree.data)
        displayLevel(tree.left)
        displayLevel(tree.right)
    }

    fun breadthFirstSearch(tree: Node?) {
        if (null == tree) {
            return
        }

        val queue = LinkedList<Node>()
        queue.add(tree)

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            println(currentNode.data)

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

    fun isBinaryTree(tree: Node?, min: Int, max: Int): Boolean {
        if (tree == null) {
            return true
        }

        if (tree.data < min || tree.data > max) {
            return false
        }

        return isBinaryTree(tree.left, min, tree.data) && isBinaryTree(tree.right, tree.data, max)
    }
}

fun main() {
    val tree = Node()
    tree.data = 100
    tree.left = Node()
    tree.left?.data = 50
    tree.right = Node()
    tree.right?.data = 200
    tree.left?.left = Node()
    tree.left?.left?.data = 25
    tree.left?.right = Node()
    tree.left?.right?.data = 75
    tree.right?.right = Node()
    tree.right?.right?.data = 350
    tree.right?.left = Node()
    tree.right?.left?.data = 90

//    LevelWiseDisplay().displayLevel(tree)
    println("------------------")
    LevelWiseDisplay().breadthFirstSearch(tree)
    println("------------------")
    println(LevelWiseDisplay().isBinaryTree(tree, Int.MIN_VALUE, Int.MAX_VALUE))
}
