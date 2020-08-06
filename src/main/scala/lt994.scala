object lt994 {
  def orangesRotting(grid: Array[Array[Int]]): Int = {
    import scala.collection.mutable

    if (grid.isEmpty) return -1
    val q = mutable.Queue.empty[(Int, Int)]
    var fresh = grid.flatten.count(_ == 1)
    val rotten = grid.flatten.count(_ == 2)

    if (fresh == 0 && rotten == 0) return 0
    if (fresh != 0 && rotten == 0) return -1

    val nrow = grid.length
    val ncol = grid.head.length

    for (i <- 0 until nrow; j <- 0 until ncol) {
      if (grid(i)(j) == 2) q.enqueue((i,j))
    }

    var minute = -1
    val directions = List((-1, 0), (0, 1), (1, 0), (0, -1))
    while (q.nonEmpty) {
      q.dequeueAll(_ => true).foreach(g => {
        directions.foreach(d => {
          val nr = g._1 + d._1
          val nc = g._2 + d._2
          if (nr >= 0 && nr < nrow && nc >= 0 && nc < ncol) {
            if (grid(nr)(nc) == 1) {
              fresh -= 1
              grid(nr)(nc) = 2
              q.enqueue((nr, nc))
            }
          }
        })
      })
      minute += 1
    }
    if (fresh == 0) minute else -1
  }
}