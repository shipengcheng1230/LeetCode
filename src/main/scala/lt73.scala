// https://leetcode.com/problems/set-matrix-zeroes/
object lt73 {
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    val m = matrix.length
    val n = matrix.head.length
    var isCol = false
    for (i <- 0 until m) {
      if (matrix(i)(0) == 0) isCol = true
      for (j <- 1 until n) {
        if (matrix(i)(j) == 0) {
          matrix(0)(j) = 0
          matrix(i)(0) = 0
        }
      }
    }
    for { i <- 1 until m; j <- 1 until n } {
      if (matrix(i)(0) == 0 || matrix(0)(j) == 0)
        matrix(i)(j) = 0
    }

    if (matrix(0)(0) == 0)
      matrix.head.indices.foreach(matrix(0)(_) = 0)

    if (isCol)
      matrix.indices.foreach(matrix(_)(0) = 0)
  }
}
