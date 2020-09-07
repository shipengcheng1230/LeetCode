// https://leetcode.com/problems/distinct-subsequences/
object lt115 {
  def numDistinct(s: String, t: String): Int = {
    val memo = scala.collection.mutable.Map.empty[(Int, Int), Int]
    val m = s.length
    val n = t.length

    def helper(i: Int, j: Int): Int = {
      if (i == m || j == n || m - i < n - j) {
        if (j == n) 1 else 0
      } else {
        memo.getOrElseUpdate((i, j), {
          helper(i + 1, j) + (if (s(i) == t(j)) helper(i + 1, j + 1) else 0)
        })
      }
    }

    helper(0, 0)
  }

  def numDistinct2(s: String, t: String): Int = {
    val m = s.length
    val n = t.length
    val dp = Array.fill(m + 1, n + 1)(0)
    (0 to n).foreach(i => dp(m)(i) = 0)
    (0 to m).foreach(i => dp(i)(n) = 1)
    for (i <- m - 1 to 0 by -1; j <- n - 1 to 0 by -1) {
      dp(i)(j) = dp(i + 1)(j)
      if (s(i) == t(j))
        dp(i)(j) += dp(i + 1)(j + 1)
    }
    dp(0)(0)
  }

  def numDistinct3(s: String, t: String): Int = {
    val m = s.length
    val n = t.length
    val dp = Array.fill(n)(0)
    var prev = 1
    for (i <- m - 1 to 0 by -1) {
      prev = 1
      for (j <- n - 1 to 0 by -1) {
        val old_dpj = dp(j)
        if (s(i) == t(j)) dp(j) += prev
        prev = old_dpj
      }
    }
    dp(0)
  }
}
