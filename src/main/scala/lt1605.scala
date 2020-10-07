// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
object lt1605 {
  def restoreMatrix(rowSum: Array[Int], colSum: Array[Int]): Array[Array[Int]] = {
    val m = rowSum.length
    val n = colSum.length
    val ans = Array.ofDim[Int](m, n)
    for (i <- 0 until m; j <- 0 until n) {
      ans(i)(j) = rowSum(i) min colSum(j)
      rowSum(i) -= ans(i)(j)
      colSum(j) -= ans(i)(j)
    }
    ans
  }
}
