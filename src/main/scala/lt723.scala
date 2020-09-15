// https://leetcode.com/problems/candy-crush/
object lt723 {
  def candyCrush(board: Array[Array[Int]]): Array[Array[Int]] = {
    val R = board.length
    val C = board.head.length
    var todo = false
    for (r <- 0 until R; c <- 0 until C - 2) {
      val v = math.abs(board(r)(c))
      if (v != 0 && v == math.abs(board(r)(c + 1)) && v == math.abs(board(r)(c + 2))) {
        board(r)(c) = -v
        board(r)(c + 1) = -v
        board(r)(c + 2) = -v
        todo = true
      }
    }

    for (r <- 0 until R - 2; c <- 0 until C) {
      val v = math.abs(board(r)(c))
      if (v != 0 && v == math.abs(board(r + 1)(c)) && v == math.abs(board(r + 2)(c))) {
        board(r)(c) = -v
        board(r + 1)(c) = -v
        board(r + 2)(c) = -v
        todo = true
      }
    }

    for (c <- 0 until C) {
      var wr = R - 1
      for (r <- R - 1 to 0 by -1; if board(r)(c) > 0) {
        board(wr)(c) = board(r)(c)
        wr -= 1
      }
      while (wr >= 0) {
        board(wr)(c) = 0
        wr -= 1
      }
    }

    if (todo) candyCrush(board) else board
  }
}
