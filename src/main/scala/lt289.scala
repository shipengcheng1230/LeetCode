// https://leetcode.com/problems/game-of-life/
object lt289 {
  def gameOfLife(board: Array[Array[Int]]): Unit = {
    val neighbors = Array(0, 1, -1)
    val rows = board.length
    val cols = board.head.length

    for {
      row <- 0 until rows
      col <- 0 until cols
    } {
      var live = 0
      for {
        i <- 0 until 3
        j <- 0 until 3
        if neighbors(i) != 0 || neighbors(j) != 0
      } {
        val r = row + neighbors(i)
        val c = col + neighbors(j)
        if (r >= 0 && c >= 0 && r < rows && c < cols && math.abs(board(r)(c)) == 1) {
          live += 1
        }
      }
      if (board(row)(col) == 1 && (live < 2 || live > 3))
        board(row)(col) = -1
      if (board(row)(col) == 0 && live == 3)
        board(row)(col) = 2
    }
    for {
      row <- 0 until rows
      col <- 0 until cols
    } {
      if (board(row)(col) > 0)
        board(row)(col) = 1
      else
        board(row)(col) = 0
    }
  }
}
