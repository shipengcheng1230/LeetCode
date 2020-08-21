// https://leetcode.com/problems/sudoku-solver/
object lt37 {
  def solveSudoku(board: Array[Array[Char]]): Unit = {
    val n = 3
    val N = 9
    val rows = Array.fill(N, N + 1)(0)
    val cols = Array.fill(N, N + 1)(0)
    val boxes = Array.fill(N, N + 1)(0)
    var solved = false

    def couldPlace(d: Int, row: Int, col: Int): Boolean = {
      val idx = (row / n) * n + col / n
      rows(row)(d) + cols(col)(d) + boxes(idx)(d) == 0
    }

    def placeNumber(d: Int, row: Int, col: Int): Unit = {
      val idx = (row / n) * n + col / n
      rows(row)(d) += 1
      cols(col)(d) += 1
      boxes(idx)(d) += 1
      board(row)(col) = d.toString.head
    }

    def removeNumber(d: Int, row: Int, col: Int): Unit = {
      val idx = (row / n) * n + col / n
      rows(row)(d) -= 1
      cols(col)(d) -= 1
      boxes(idx)(d) -= 1
      board(row)(col) = '.'
    }

    def placeNextNumber(row: Int, col: Int): Unit = {
      if ((row == N - 1) && (col == N - 1))
        solved = true
      else {
        if (col == N - 1)
          backtrack(row + 1, 0)
        else
          backtrack(row, col + 1)
      }
    }

    def backtrack(row: Int, col: Int): Unit = {
      if (board(row)(col) == '.') {
        (1 to 9).foreach(d => {
          if (couldPlace(d, row, col)) {
            placeNumber(d, row, col)
            placeNextNumber(row, col)
            if (!solved)
              removeNumber(d, row, col)
          }
        })
      } else placeNextNumber(row, col)
    }

    for {
      i <- 0 until N
      j <- 0 until N
    } {
      val c = board(i)(j)
      if (c != '.')
        placeNumber(c.asDigit, i, j)
    }

    backtrack(0, 0)
  }
}
