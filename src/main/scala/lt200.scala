object lt200 {
  def numIslands(grid: Array[Array[Char]]): Int = {

    if (grid.isEmpty || grid(0).isEmpty) return 0
    val directions = Vector((0,1), (0,-1), (1,0), (-1,0))
    val width = grid(0).length
    val height = grid.length
    val grid2 = grid.clone()

    def dfs(x: Int, y: Int): Unit = (x, y) match {
      case (x, _) if x < 0 || x >= width =>
      case (_, y) if y < 0 || y >= height =>
      case (x, y) if grid2(y)(x) == '1' =>
        grid2(y)(x) = '0'
        directions.foreach(d => dfs(x + d._1, y + d._2))
      case _ =>
    }

    var island = 0
    for {
      y <- 0 until height
      x <- 0 until width
      if grid(y)(x) == '1'
    } {
      island += 1
      dfs(x, y)
    }
    island
  }
}
