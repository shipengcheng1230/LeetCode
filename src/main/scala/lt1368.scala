// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
object lt1368 {
  def minCost(grid: Array[Array[Int]]): Int = {
    import scala.collection.mutable
    import scala.annotation.tailrec

    val dirs = Array((0,1), (0,-1), (1,0), (-1,0))
    val m = grid.length
    val n = grid.head.length
    val dp = Array.fill(m, n)(Integer.MAX_VALUE)
    val q = mutable.Queue.empty[(Int, Int)]
    var cost = 0

    @tailrec
    def dfs(r: Int, c: Int, cost: Int): Unit = {
      if (r >= 0 && c >= 0 && r < m && c < n && dp(r)(c) == Integer.MAX_VALUE) {
        dp(r)(c) = cost
        q.enqueue((r, c))
        val next = dirs(grid(r)(c) - 1)
        dfs(r + next._1, c + next._2, cost)
      }
    }

    dfs(0, 0, 0)
    while (q.nonEmpty) {
      cost += 1
      q.dequeueAll(_ => true).foreach(p => {
        dirs.foreach(d => dfs(p._1 + d._1, p._2 + d._2, cost))
      })
    }
    dp(m-1)(n-1)
  }
}
