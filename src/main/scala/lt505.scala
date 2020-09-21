// https://leetcode.com/problems/the-maze-ii/
object lt505 {
  def shortestDistance(maze: Array[Array[Int]], start: Array[Int], destination: Array[Int]): Int = {
    import scala.collection.mutable

    val m = maze.length
    val n = maze.head.length
    val dirs = List((0, 1), (0, -1), (-1, 0), (1, 0))
    val distance = Array.fill(m, n)(Int.MaxValue)
    val q = mutable.Queue.empty[(Int, Int)]
    q.enqueue((start(0), start(1)))
    distance(start(0))(start(1)) = 0
    while (q.nonEmpty) {
      val (x, y) = q.dequeue()
      dirs.foreach(d => {
        var nx = x + d._1
        var ny = y + d._2
        var count = 0
        while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze(nx)(ny) == 0) {
          nx += d._1
          ny += d._2
          count += 1
        }
        if (distance(nx - d._1)(ny - d._2) > distance(x)(y) + count) {
          q.enqueue((nx - d._1, ny - d._2))
          distance(nx - d._1)(ny - d._2) = distance(x)(y) + count
        }
      })
    }
    if (distance(destination(0))(destination(1)) == Int.MaxValue) -1 else distance(destination(0))(destination(1))
  }
}
