object lt329 {
  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {

    if (matrix.isEmpty) return 0
    val rows = matrix.length
    val cols = matrix.head.length
    val cache = Array.fill(rows, cols)(0)
    var ret = 1
    val dirs = List((0, 1), (0, -1), (-1, 0), (1, 0))

    def dfs(i: Int, j: Int): Int = {
      if (cache(i)(j) != 0) cache(i)(j)
      else {
        var curMax = 1
        dirs.foreach(dir => {
          val x = i + dir._1
          val y = j + dir._2
          if (x >= 0 && x < rows && y >= 0 && y < cols && matrix(x)(y) > matrix(i)(j)) {
            curMax = curMax max (1 + dfs(x, y))
          }
        })
        cache(i)(j) = curMax
        curMax
      }
    }

    for {
      i <- 0 until rows
      j <- 0 until cols
    } ret = ret max dfs(i, j)
    ret
  }
}

//[[3,4,5],[3,2,6],[2,2,1]]
//[[9,9,4],[6,6,8],[2,1,1]]