// https://leetcode.com/problems/max-area-of-island/
object lt695 {
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {

    if (grid.isEmpty || grid.head.isEmpty) return 0

    val m = grid.length
    val n = grid.head.length
    var ans = 0
    val dirs = List((0, 1), (0, -1), (-1, 0), (1, 0))

    def dfs(x: Int, y: Int): Int = {
      if (x >= 0 && x < m && y >= 0 && y < n && grid(x)(y) == 1) {
        grid(x)(y) = 0
        val ret = dirs.map(d => dfs(x + d._1, y + d._2)).sum + 1
        ans = ans max ret
        ret
      } else 0
    }

    for {
      i <- 0 until m
      j <- 0 until n
      if grid(i)(j) == 1
    } dfs(i, j)

    ans
  }
}
