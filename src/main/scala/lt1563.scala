// https://leetcode.com/problems/stone-game-v/
object lt1563 {
  def stoneGameV(stoneValue: Array[Int]): Int = {
    val n = stoneValue.length
    val dp = Array.fill(n, n)(0)
    val acc = stoneValue.scanLeft(0)(_ + _)

    def dfs(from: Int, to: Int): Int = {
      if (from == to) 0
      else if (dp(from)(to) > 0) dp(from)(to)
      else {
        for (d <- from + 1 to to) {
          val first = acc(d) - acc(from)
          val second = acc(to + 1) - acc(d)
          if (first == second) dp(from)(to) =
            dp(from)(to) max (first + (dfs(from, d - 1) max dfs(d, to)))
          else if (first > second) dp(from)(to) = dp(from)(to) max (second + dfs(d, to))
          else dp(from)(to) = dp(from)(to) max (first + dfs(from, d - 1))
        }
        dp(from)(to)
      }
    }

    dfs(0, n - 1)
  }
}
