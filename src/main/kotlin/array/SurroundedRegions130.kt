package array

/**
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 *
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region
 * cells are on the edge of the board.
 * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to
 * return anything.
 *
 *
 *
 * Example 1:
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 *
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 */
class SurroundedRegions130 {
    fun solve(board: Array<CharArray>): Unit {
        val c = board.size
        val r = board[0].size
        val visited = mutableSetOf<Pair<Int, Int>>()

        for (i in 0 until c) {
            for (j in 0 until r) {
                if (i == 0 || i == c - 1 || j == 0 || j == r - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j, visited)
                    }
                }
            }
        }
        for (i in 0 until c) {
            for (j in 0 until r) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O'
                } else {
                    continue
                }
            }
        }
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int, vis: MutableSet<Pair<Int, Int>>) {
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || vis.contains(Pair(i, j)) || board[i][j] != 'O') {
            return
        }
        vis.add(Pair(i, j))
        board[i][j] = 'T'
        dfs(board, i + 1, j, vis)
        dfs(board, i - 1, j, vis)
        dfs(board, i, j + 1, vis)
        dfs(board, i, j - 1, vis)
    }
}

fun main() {
    val testClass = SurroundedRegions130()
    val input = arrayOf(
        charArrayOf('X','X','X','X'),
        charArrayOf('X','O','O','X'),
        charArrayOf('X','X','O','X'),
        charArrayOf('X','O','X','X'),
    )
    testClass.solve(input)
    input.forEach {
        println("")
        it.forEach { c -> print(c) }
    }
}