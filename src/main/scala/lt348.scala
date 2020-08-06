object lt348 {
  class TicTacToe(_n: Int) {

    val horizontal = Array.fill[Int](2, _n)(0)
    val vertical = Array.fill[Int](2, _n)(0)
    val diagonal = Array.fill[Int](2, 2)(0)

    def move(row: Int, col: Int, player: Int): Int = {
      val p = player % 2

      horizontal(p)(row) += 1
      if (horizontal(p)(row) == _n) return player
      vertical(p)(col) += 1
      if (vertical(p)(col) == _n) return player
      if (row == col) {
        diagonal(p)(0) += 1
        if (diagonal(p)(0) == _n) return player
      }
      if (row + col + 1 == _n) {
        diagonal(p)(1) += 1
        if (diagonal(p)(1) == _n) return player
      }
      return 0
    }

  }
}
