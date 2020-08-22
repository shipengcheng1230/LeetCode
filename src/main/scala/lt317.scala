// https://leetcode.com/problems/shortest-distance-from-all-buildings/
object lt317 {
  def shortestDistance(grid: Array[Array[Int]]): Int = {
    if (grid.isEmpty || grid.head.isEmpty) return -1

    import scala.collection.mutable
    val m = grid.length
    val n = grid.head.length
    val dist = Array.fill(m, n)(0)
    val dirs = List((1,0), (0,1), (-1,0), (0,-1))
    val buildings = mutable.ArrayBuffer.empty[(Int, Int, Int)]
    for { i <- 0 until m; j <- 0 until n } {
      if (grid(i)(j) == 1)
        buildings.append((i, j, 0))
      grid(i)(j) *= -1
    }
    buildings.indices.foreach(k => bfs(buildings(k), k))

    def bfs(root: (Int, Int, Int), k: Int): Unit = {
      val q = mutable.Queue.empty[(Int, Int, Int)]
      q.enqueue(root)
      while (q.nonEmpty) {
        val b = q.dequeue()
        dist(b._1)(b._2) += b._3
        dirs.foreach(dir => {
          val x = b._1 + dir._1
          val y = b._2 + dir._2
          if (x >= 0 && x < m && y >= 0 && y < n && grid(x)(y) == k) {
            grid(x)(y) = k + 1
            q.enqueue((x, y, b._3 + 1))
          }
        })
      }
    }

    var ans = -1
    for {
      i <- 0 until m
      j <- 0 until n
      if (grid(i)(j) == buildings.length && (ans < 0 || dist(i)(j) < ans))
    } {
      ans = dist(i)(j)
    }
    ans
  }
}
