// https://leetcode.com/problems/valid-sudoku/
object lt36 {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    import scala.collection.mutable

    for (i <- 0 until 9) {
      val rows = mutable.Set.empty[Char]
      val cols = rows.clone()
      val cube = cols.clone()
      for (j <- 0 until 9) {
        if (board(i)(j) != '.' && !rows.add(board(i)(j)))
          return false
        if (board(j)(i) != '.' && !cols.add(board(j)(i)))
          return false
        val rowIndex = 3 * (i / 3)
        val colIndex = 3 * (i % 3)
        if (board(rowIndex + j / 3)(colIndex + j % 3) != '.'
          && !cube.add(board(rowIndex + j / 3)(colIndex + j % 3)))
          return false
      }
    }
    true
  }
}
