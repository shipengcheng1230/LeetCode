// https://leetcode.com/problems/minimum-falling-path-sum-ii/
object lt1289 {
  def minFallingPathSum(arr: Array[Array[Int]]): Int = {
    val m = arr.length
    val n = arr.head.length
    val prev = arr.head.clone()
    for (i <- 1 until m) {
      val dp = Array.fill(n)(0)
      var firstMin = -1
      var secondMin = -1
      for (j <- 0 until n) {
        if (j == 0) dp(j) = prev.slice(j + 1, n).min
        else if (j == n - 1) dp(j) = prev.slice(0, j).min
        else dp(j) = prev.slice(0, j).min min prev.slice(j + 1, n).min
      }
      for (j <- 0 until n) {
        prev(j) = dp(j) + arr(i)(j)
      }
    }
    prev.min
  }
}
