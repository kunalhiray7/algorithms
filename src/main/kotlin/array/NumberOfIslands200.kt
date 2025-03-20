package array

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
class NumberOfIslands200 {
    /*fun numIslands(grid: Array<CharArray>): Int {
        var noOfIslands = 0

        grid.forEachIndexed { row, chars ->
            chars.forEachIndexed { col, cell ->
                if(cell == '1' && noOfIslands == 0) {
                    noOfIslands++
                } else if(cell == '1' && noAdjacentIsland(col - 1, col + 1, chars) && noVerticalIsland(row - 1, row + 1, col, grid)) {
                    noOfIslands++
                }
            }
        }

        return noOfIslands
    }

    private fun noVerticalIsland(up: Int, down: Int, col: Int, grid: Array<CharArray>): Boolean {
        if(up >= 0 && grid[up][col] == '1') {
            return false
        }

        if(down < grid.size && grid[down][col] == '1') {
            return false
        }

        return true
    }

    private fun noAdjacentIsland(prev: Int, next: Int, chars: CharArray): Boolean {
        if(prev >= 0 && chars[prev] == '1') {
            return false
        }

        if(next < chars.size && chars[next] == '1') {
            return false
        }

        return true
    }*/

    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0

        var noOfIslands = 0
        val rows = grid.size
        val cols = grid[0].size

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == '1') {
                    noOfIslands++
                    dfs(grid, row, col)
                }
            }
        }

        return noOfIslands
    }

    private fun dfs(grid: Array<CharArray>, row: Int, col: Int) {
        if (row < 0 || col < 0 || row >= grid.size || col >= grid[0].size || grid[row][col] == '0') {
            return
        }

        grid[row][col] = '0' // Mark the cell as visited

        // Visit all adjacent cells (up, down, left, right)
        dfs(grid, row - 1, col)
        dfs(grid, row + 1, col)
        dfs(grid, row, col - 1)
        dfs(grid, row, col + 1)
    }
}

fun main() {
    val classToTest = NumberOfIslands200()
    println(
        classToTest.numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
        )
    )

    println(
        classToTest.numIslands(
            arrayOf(
                charArrayOf('1', '1')
            )
        )
    )
}