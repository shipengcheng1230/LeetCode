// https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
object lt1594 {
  def maxProductPath(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid.head.length
    val mod = 1_000_000_007

    val dp = Array.fill(m, n, 2)(0L)
    dp(0)(0)(0) = grid(0)(0)
    dp(0)(0)(1) = grid(0)(0)

    for (i <- 0 until m; j <- 0 until n; if !(i == 0 && j == 0)) {
      if (i == 0) {
        dp(i)(j)(0) = dp(i)(j - 1)(0) * grid(i)(j)
        dp(i)(j)(1) = dp(i)(j)(0)
      } else if (j == 0) {
        dp(i)(j)(0) = dp(i - 1)(j)(0) * grid(i)(j)
        dp(i)(j)(1) = dp(i)(j)(0)
      } else {
        val a = grid(i)(j) * math.max(dp(i - 1)(j)(0), dp(i)(j - 1)(0))
        val b = grid(i)(j) * math.min(dp(i - 1)(j)(1), dp(i)(j - 1)(1))
        dp(i)(j)(0) = a max b
        dp(i)(j)(1) = a min b
      }
    }
    if (dp(m - 1)(n - 1)(0) < 0) -1 else (dp(m - 1)(n - 1)(0) % mod).toInt
  }
}
