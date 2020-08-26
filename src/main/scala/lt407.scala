// https://leetcode.com/problems/trapping-rain-water-ii/
object lt407 {
  def trapRainWater(heightMap: Array[Array[Int]]): Int = {
    val dirs = List((1,0), (0,1), (-1,0), (0,-1))
    val m = heightMap.length
    val n = if (m == 0) 0 else heightMap.head.length
    var res = 0
    val pq = scala.collection.mutable.PriorityQueue.empty[(Int, Int, Int)](Ordering.by(_._3)).reverse
    val seen = Array.fill(m, n)(false)
    (0 until m).foreach(i => {
      pq.enqueue((i, 0, heightMap(i)(0)))
      pq.enqueue((i, n - 1, heightMap(i)(n - 1)))
      seen(i)(0) = true
      seen(i)(n - 1) = true
    })
    (1 until n - 1).foreach(j => {
      pq.enqueue((0, j, heightMap(0)(j)))
      pq.enqueue((m - 1, j, heightMap(m - 1)(j)))
      seen(0)(j) = true
      seen(m - 1)(j) = true
    })

    while (pq.nonEmpty) {
      val cell = pq.dequeue()
      dirs.foreach(d => {
        val i = cell._1 + d._1
        val j = cell._2 + d._2
        if (i >= 0 && i < m && j >= 0 && j < n && !seen(i)(j)) {
          res += math.max(0, cell._3 - heightMap(i)(j))
          pq.enqueue((i, j, math.max(heightMap(i)(j), cell._3)))
          seen(i)(j) = true
        }
      })
    }

    res
  }
}
