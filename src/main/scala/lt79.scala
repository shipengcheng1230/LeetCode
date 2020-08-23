// https://leetcode.com/problems/word-search/
object lt79 {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val m = board.length
    val n = board.head.length
    val dirs = List((0,1), (0,-1), (1,0), (-1,0))

    def backtrack(i: Int, j: Int, index: Int): Boolean = {
      if (index >= word.length) true
      else {
        if (i >= 0 && i < m && j >= 0 && j < n && board(i)(j) == word(index)) {
          board(i)(j) = '#'
          val ret = dirs.exists(dir => {
            backtrack(i + dir._1, j + dir._2, index + 1)
          })
          board(i)(j) = word(index)
          ret
        } else false
      }
    }

    for {
      i <- 0 until m
      j <- 0 until n
    } {
      if (backtrack(i, j, 0)) return true
    }
    false
  }
}
