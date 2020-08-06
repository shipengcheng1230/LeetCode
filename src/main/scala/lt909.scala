object lt909 {
  def snakesAndLadders(board: Array[Array[Int]]): Int = {

    import scala.collection.mutable.Queue

    val n = board.length
    val n2 = n * n

    def getBoardValue(num: Int): Int = {
      val r = (num - 1) / n
      val x = n - 1 - r
      val y = if (r % 2 == 0) num - 1 - r * n else n + r * n - num
      board(x)(y)
    }

    val q = Queue.empty[Int]
    val visited = Array.fill[Boolean](n2)(false)
    q.enqueue(1)
    var move = 0

    while (q.nonEmpty) {
      q.dequeueAll(_ => true).foreach(x => {
        if (!visited(x)) {
          if (x == n2) return move
          visited(x) = true
          (1 to 6).filter(_ + x <= n2).foreach(i => {
            val value = getBoardValue(x + i)
            val next = if (value > 0) value else x + i
            if (!visited(next)) q.enqueue(next)
          })
        }
      })
      move += 1
    }
    -1
  }
}
