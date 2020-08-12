// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
object lt1293 {
  def shortestPath(grid: Array[Array[Int]], k: Int): Int = {
    import scala.collection.mutable

    val m = grid.length
    val n = grid.head.length
    val q = mutable.Queue.empty[(Int, Int, Int)]
    val visited = mutable.Map.empty[(Int, Int), Int]
    val dirs = List((0,1), (0,-1), (-1,0), (1,0))
    q.enqueue((0, 0, 0))
    visited.update((0, 0), 0)
    var step = 0
    while (q.nonEmpty) {
      q.dequeueAll(_ => true).foreach(p => {
        if (p._1 == m - 1 && p._2 == n - 1) return step
        if (p._3 <= k) {
          dirs.foreach(d => {
            val x = d._1 + p._1
            val y = d._2 + p._2
            if (x >= 0 && y >= 0 && x < m && y < n) {
              val no = p._3 + (if (grid(x)(y) == 1) 1 else 0)
              if (no < visited.getOrElse((x, y), Integer.MAX_VALUE)) {
                visited.update((x, y), no)
                q.enqueue((x, y, no))
              }
            }
          })
        }
      })
      step += 1
    }
    -1
  }
}
