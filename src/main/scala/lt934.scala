// https://leetcode.com/problems/shortest-bridge/
object lt934 {
  def shortestBridge(A: Array[Array[Int]]): Int = {
    import scala.collection.mutable

    val q = mutable.Queue.empty[(Int, Int)]
    val m = A.length
    val n = A.head.length
    val seen = Array.fill(m, n)(false)
    val dirs = List((0, 1), (0, -1), (-1, 0), (1, 0))
    var firstDFS = true

    def dfs(i: Int, j: Int): Unit = {
      seen(i)(j) = true
      q.enqueue((i, j))
      dirs.foreach(d => {
        val x = i + d._1
        val y = j + d._2
        if (x >= 0 && x < m && y >= 0 && y < n && A(x)(y) == 1 && !seen(x)(y)) {
          dfs(x, y)
        }
      })
    }

    for { i <- 0 until m; j <- 0 until n; if A(i)(j) == 1 && firstDFS } {
      dfs(i, j)
      firstDFS = false
    }

    var step = 0
    while (q.nonEmpty) {
      q.dequeueAll(_ => true).foreach(p => {
        dirs.foreach(d => {
          val x = p._1 + d._1
          val y = p._2 + d._2
          if (x >= 0 && x < m && y >= 0 && y < n && !seen(x)(y)) {
            if (A(x)(y) == 1)
              return step
            q.enqueue((x, y))
            seen(x)(y) = true
          }
        })
      })
      step += 1
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    println(shortestBridge(Array(Array(1,0,0), Array(0,0,0), Array(0,0,1))))
  }
}
