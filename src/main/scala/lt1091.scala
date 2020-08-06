object lt1091 {
  def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {
    import scala.collection.mutable

    if (grid.isEmpty) return -1
    if (grid.head.head == 1) return -1
    val nrow = grid.length
    val ncol = grid.head.length
    val q = mutable.Queue.empty[(Int, Int)]
    val directions = List((-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1))
    q.enqueue((0, 0))
    var nstep = 1
    while (q.nonEmpty) {
      q.dequeueAll(_ => true).foreach(g => {
        if (g._1 == nrow-1 && g._2 == ncol-1) return nstep
        directions.foreach(d => {
          val nr = g._1 + d._1
          val nc = g._2 + d._2
          if (nr >= 0 && nr < nrow && nc >= 0 && nc < ncol) {
            if (grid(nr)(nc) == 0) {
              grid(nr)(nc) = 1
              q.enqueue((nr, nc))
            }
          }
        })
      })
      nstep += 1
    }
    -1
  }
}