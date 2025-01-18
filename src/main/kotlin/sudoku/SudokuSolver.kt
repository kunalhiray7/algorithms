package sudoku

class SudokuSolver {
    fun solveSudoku(board: Array<CharArray>): Unit {
        solve(board)
    }

    private fun solve(board: Array<CharArray>): Boolean {
        for (row in board.indices) {
            for (col in board[row].indices) {
                if (board[row][col] == '.') {
                    for (num in '1'..'9') {
                        if (isValid(board, num, row, col)) {
                            board[row][col] = num
                            if (solve(board)) {
                                return true
                            } else {
                                board[row][col] = '.'
                            }
                        }
                    }
                    return false
                }
            }
        }
        return true
    }

    private fun isValidRow(board: Array<CharArray>, num: Char, row: Int): Boolean {
        return !board[row].contains(num)
    }

    private fun isValidColumn(board: Array<CharArray>, num: Char, col: Int): Boolean {
        board.forEach { row ->
            if (row[col] == num) {
                return false
            }
        }
        return true
    }

    private fun isValidBox(board: Array<CharArray>, num: Char, row: Int, col: Int): Boolean {
        val boxStartRow = row - row % 3
        val boxStartCol = col - col % 3
        for (i in boxStartRow until boxStartRow + 3) {
            for (j in boxStartCol until boxStartCol + 3) {
                if (board[i][j] == num) {
                    return false
                }
            }
        }
        return true
    }

    private fun isValid(board: Array<CharArray>, num: Char, row: Int, col: Int): Boolean {
        return isValidRow(board, num, row) && isValidColumn(board, num, col) && isValidBox(board, num, row, col)
    }
}

fun main() {
    val classToTest = SudokuSolver()

    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    classToTest.solveSudoku(board)

    print(board)
}

private fun print(board: Array<CharArray>) {
    for (row in board) {
        println(row)
    }
}