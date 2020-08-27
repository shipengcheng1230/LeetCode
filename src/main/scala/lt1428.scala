// https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
object lt1428 {

  class BinaryMatrix {
    def get(row: Int, col: Int): Int = {???}
    def dimensions(): Array[Int] = {???}
  }

  def leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int = {
    val Array(m, n) = binaryMatrix.dimensions()
    var row = 0
    var col = n - 1
    while (row < m && col > -1) {
      if (binaryMatrix.get(row, col) == 0)
        row += 1
      else
        col -= 1
    }
    if (col == n - 1) -1 else col + 1
  }

}
