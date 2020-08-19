// https://leetcode.com/problems/rotate-image/
object lt48 {
  def rotate(matrix: Array[Array[Int]]): Unit = {
    val n = matrix.length

    for (i <- 0 until n; j <- i until n) {
      val tmp = matrix(i)(j)
      matrix(i)(j) = matrix(j)(i)
      matrix(j)(i) = tmp
    }
    for (i <- 0 until n; j <- 0 until n / 2) {
      val tmp = matrix(i)(j)
      matrix(i)(j) = matrix(i)(n - j - 1)
      matrix(i)(n - j - 1) = tmp
    }
  }
}
