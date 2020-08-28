// https://leetcode.com/problems/pacific-atlantic-water-flow/
object lt417 {
  def pacificAtlantic(matrix: Array[Array[Int]]): List[List[Int]] = {
    if (matrix.isEmpty || matrix.head.isEmpty) return Nil
    val m = matrix.length
    val n = matrix.head.length
    val pacific = Array.fill(m, n)(false)
    val atlantic = pacific.map(_.clone())
    val dirs = List((0, 1), (0, -1), (-1, 0), (1, 0))

    def dfs(i: Int, j: Int, height: Int, seen: Array[Array[Boolean]]): Unit = {
      if (i >= 0 && i < m && j >= 0 && j < n && !seen(i)(j) && matrix(i)(j) >= height) {
        seen(i)(j) = true
        dirs.foreach(d => {
          dfs(i + d._1, j + d._2, matrix(i)(j), seen)
        })
      }
    }

    (0 until m).foreach(i => {
      dfs(i, 0, Int.MinValue, pacific)
      dfs(i, n - 1, Int.MinValue, atlantic)
    })

    (0 until n).foreach(i => {
      dfs(0, i, Int.MinValue, pacific)
      dfs(m - 1, i, Int.MinValue, atlantic)
    })

    (for { i <- 0 until m; j <- 0 until n; if (pacific(i)(j) && atlantic(i)(j)) }
      yield (List(i, j))).toList

  }
}
