// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
object lt718 {
  def findLength(A: Array[Int], B: Array[Int]): Int = {
    val m = A.length
    val n = B.length
    val dp = Array.fill(m + 1, n + 1)(0)
    for {
      i <- m - 1 to 0 by - 1
      j <- n - 1 to 0 by - 1
      if A(i) == B(j)
    } {
      dp(i)(j) = dp(i + 1)(j + 1) + 1
    }

    dp.map(_.max).max
  }
}
