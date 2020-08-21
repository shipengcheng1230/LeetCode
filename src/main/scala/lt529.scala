// https://leetcode.com/problems/minesweeper/
object lt529 {
  def updateBoard(board: Array[Array[Char]], click: Array[Int]): Array[Array[Char]] = {
    if (board.isEmpty || board.head.isEmpty) board
    else {
      val m = board.length
      val n = board.head.length
      val dirs = List((1, 0), (-1, 0), (0, 1), (0, -1), (1, 1), (1, -1), (-1, 1), (-1, -1))

      def dfs(x: Int, y: Int): Unit = {
        if (x >= 0 && x < m && y >= 0 && y < n && board(x)(y) == 'E') {
          val mines = adjMines(x, y)
          if (mines > 0)
            board(x)(y) = ('0' + mines).toChar
          else {
            board(x)(y) = 'B'
            dirs.foreach(dir => dfs(x + dir._1, y + dir._2))
          }
        }
      }

      def adjMines(x: Int, y: Int): Int = {
        var count = 0
        for {
          i <- x - 1 to x + 1
          j <- y - 1 to y + 1
          if i >= 0 && i < m && j >= 0 && j < n && board(i)(j) == 'M'
        } count += 1
        count
      }

      if (board(click(0))(click(1)) == 'M')
        board(click(0))(click(1)) = 'X'
      else
        dfs(click(0), click(1))

      board
    }
  }
}
