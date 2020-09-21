// https://leetcode.com/problems/the-maze/
object lt490 {
  def hasPath(maze: Array[Array[Int]], start: Array[Int], destination: Array[Int]): Boolean = {
    import scala.collection.mutable

    val m = maze.length
    val n = maze.head.length
    val visited = Array.fill(m, n)(false)
    val dirs = List((0, 1), (0, -1), (-1, 0), (1, 0))
    val q = mutable.Queue.empty[(Int, Int)]
    q.enqueue((start(0), start(1)))
    visited(start(0))(start(1)) = true
    while (q.nonEmpty) {
      val (x, y) = q.dequeue()
      if (x == destination(0) && y == destination(1)) return true
      dirs.foreach(d => {
        var nx = x + d._1
        var ny = y + d._2
        while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze(nx)(ny) == 0) {
          nx += d._1
          ny += d._2
        }
        if (!visited(nx - d._1)(ny - d._2)) {
          q.enqueue((nx - d._1, ny - d._2))
          visited(nx - d._1)(ny - d._2) = true
        }
      })
    }
    false
  }
}
