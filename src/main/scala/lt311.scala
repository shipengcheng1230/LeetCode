// https://leetcode.com/problems/sparse-matrix-multiplication/
object lt311 {
  def multiply(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
    val m = A.length
    val n = A.head.length
    val nB = B.head.length
    val C = Array.fill(m, nB)(0)
    for {
      i <- 0 until m
      k <- 0 until n
      if A(i)(k) != 0
      j <- 0 until nB
      if B(k)(j) != 0
    } C(i)(j) += A(i)(k) * B(k)(j)

    C
  }
}
