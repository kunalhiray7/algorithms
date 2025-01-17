package array

import java.util.Stack

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 */
class ShortestPathInBinaryMatrix {

    // A state class to represent each node with its depth
    data class State(
            val row: Int,
            val col: Int,
            val steps: Int
    )

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {

        // Intuition and algorithm:
        // Since we want the shortest path, we use BFS to find this path.
        // We use a queue to keep the nodes in each level.
        // We use an array of directions to facilitate movement between two nodes (in 8 directions).
        // We use a "seen" matrix to prevent visiting a node more than once.
        // We define a State class to keep track of the steps for each node we visit.
        // For BFS, we process nodes level by level until we reach the destination or exhaust all possibilities.

        val n = grid.size
        val queue = ArrayDeque<State>()
        val seen = Array(n) { BooleanArray(n) }

        // 8 possible directions (up, down, left, right, and 4 diagonals)
        val directions = arrayOf(
                intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1),
                intArrayOf(-1, -1), intArrayOf(1, 1), intArrayOf(-1, 1), intArrayOf(1, -1)
        )

        // Start BFS from the top-left corner if it is 0
        if (grid[0][0] == 0) {
            queue.add(State(0, 0, 1))
            seen[0][0] = true
        }

        // Function to validate a cell: it should be within bounds and should be 0
        fun isValid(row: Int, col: Int): Boolean {
            return (row in 0.. n) && (col in 0..n) && (grid[row][col] == 0)
        }

        // Perform BFS
        while (queue.isNotEmpty()) {
            val (row, col, steps) = queue.removeFirst()

            // If we reached the bottom-right corner, return the number of steps
            if (row == n - 1 && col == n - 1) return steps

            // Check all 8 possible directions to add valid and unseen cells to the queue
            for ((x, y) in directions) {
                val nextRow = row + x
                val nextCol = col + y

                // Consider this cell if it's valid and not yet seen
                if (isValid(nextRow, nextCol) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true
                    queue.addLast(State(nextRow, nextCol, steps + 1))
                }
            }
        }

        // If there's no path, return -1
        return -1
    }
}