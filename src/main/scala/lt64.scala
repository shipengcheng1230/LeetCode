// https://leetcode.com/problems/minimum-path-sum/
object lt64 {
  def minPathSum(grid: Array[Array[Int]]): Int = {
    if (grid.isEmpty || grid.head.isEmpty) return 0
    val m = grid.length
    val n = grid.head.length
    val dp = Array.fill(m, n)(0)
    dp(0)(0) = grid(0)(0)

    def helper(i: Int, j: Int): Int = {
      if (dp(i)(j) != 0) dp(i)(j)
      else {
        if (i == 0)
          dp(i)(j) = grid(i)(j) + grid(i)(j - 1)
        else if (j == 0)
          dp(i)(j) = grid(i)(j) + grid(i-1)(j)
        else
          dp(i)(j) = grid(i)(j) + grid(i)(j - 1).min(grid(i - 1)(j))
        dp(i)(j)
      }
    }

    helper(m - 1, n - 1)
  }
}
