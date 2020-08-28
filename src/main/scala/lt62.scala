// https://leetcode.com/problems/unique-paths/
object lt62 {
  def uniquePaths(m: Int, n: Int): Int = {
    val dp = Array.fill(m, n)(1)
    for {i <- 1 until m; j <- 1 until n} {
      dp(i)(j) = dp(i - 1)(j) + dp(i)(j - 1)
    }
    dp.last.last
  }
}
