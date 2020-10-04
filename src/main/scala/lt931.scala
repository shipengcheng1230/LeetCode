// https://leetcode.com/problems/minimum-falling-path-sum/
object lt931 {
  def minFallingPathSum(A: Array[Array[Int]]): Int = {
    val m = A.length
    val n = A.head.length
    val prev = A.head.clone()

    (1 until m).foreach(i => {
      val dp = Array.fill(n)(Int.MinValue)
      (0 until n).foreach(j => {
        if (j == 0) dp(j) = prev(j) min prev(j + 1)
        else if (j == n - 1) dp(j) = prev(j) min prev(j - 1)
        else dp(j) = prev(j) min prev(j - 1) min prev(j + 1)
      })
      (0 until n).foreach(j => prev(j) = dp(j) + A(i)(j))
    })
    prev.min
  }
}
