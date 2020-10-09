// https://leetcode.com/problems/path-with-maximum-gold/
object lt1219 {
  def getMaximumGold(grid: Array[Array[Int]]): Int = {
    val directions = List((0, 1), (1, 0), (-1, 0), (0, -1))
    val m = grid.length
    val n = grid.head.length

    def dfs(i: Int, j: Int): Int = {
      if (i < 0 || j < 0 || i >= m || j >= n || grid(i)(j) <= 0) 0
      else {
        grid(i)(j) *= -1
        val explored = directions.map(d => dfs(i + d._1, j + d._2)).max
        grid(i)(j) *= -1
        explored + grid(i)(j)
      }
    }

    (for (i <- 0 until m; j <- 0 until n) yield dfs(i, j)).max
  }
}
