// https://leetcode.com/problems/walls-and-gates/
object lt286 {
  def wallsAndGates(rooms: Array[Array[Int]]): Unit = {
    if (rooms.isEmpty || rooms.head.isEmpty) return

    import scala.collection.mutable

    val seen = mutable.Set.empty[(Int, Int)]
    val m = rooms.length
    val n = rooms.head.length
    val q = mutable.Queue.empty[(Int, Int)]
    val dirs = List((0, 1), (0, -1), (-1, 0), (1, 0))
    for (i <- 0 until m; j <- 0 until n; if rooms(i)(j) == 0) {
      q.enqueue((i, j))
    }
    var distance = 1
    while (q.nonEmpty) {
      q.dequeueAll(_ => true).foreach(p => {
        dirs.foreach(d => {
          val x = p._1 + d._1
          val y = p._2 + d._2
          if (x >= 0 && x < m && y >= 0 && y < n && rooms(x)(y) == Int.MaxValue) {
            rooms(x)(y) = distance
            q.enqueue((x, y))
          }
        })
      })
      distance += 1
    }
  }
}
