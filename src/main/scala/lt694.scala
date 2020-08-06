object lt694 {
  def numDistinctIslands(grid: Array[Array[Int]]): Int = {
    if (grid.isEmpty) return 0

    import scala.collection.mutable

    val seen = mutable.Set.empty[(Int, Int)]
    val shapes = mutable.Set.empty[List[Int]]

    val nrow = grid.length
    val ncol = grid.head.length

    def dfs(r: Int, c: Int, di: Int, shape: mutable.ListBuffer[Int]): Unit = {
      if (r >= 0 && r < nrow && c >= 0 && c < ncol &&
        grid(r)(c) == 1 && !seen.contains((r, c))) {

        seen.addOne((r, c))
        shape.append(di)
        dfs(r + 1, c, 1, shape)
        dfs(r - 1, c, 2, shape)
        dfs(r, c + 1, 3, shape)
        dfs(r, c - 1, 4, shape)
        shape.append(0)
      }
    }

    for {
      i <- 0 until nrow
      j <- 0 until ncol
    } {
      val shape = mutable.ListBuffer.empty[Int]
      dfs(i, j, 0, shape)
      shapes.addOne(shape.toList)
    }
    shapes.remove(Nil)
    shapes.size
  }
}