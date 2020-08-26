// https://leetcode.com/problems/battleships-in-a-board/
object lt419 {
  def countBattleships(board: Array[Array[Char]]): Int = {
    if (board.isEmpty || board.head.isEmpty) 0
    else {
      val m = board.length
      val n = board.head.length
      var count = 0
      for {
        i <- 0 until m
        j <- 0 until n
      } {
        if (board(i)(j) == 'X')
          if (i == 0 || board(i - 1)(j) != 'X')
            if (j == 0 || board(i)(j - 1) != 'X')
              count += 1
      }
      count
    }
  }
}
