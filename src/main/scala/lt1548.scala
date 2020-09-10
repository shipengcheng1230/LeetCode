// https://leetcode.com/problems/the-most-similar-path-in-a-graph/
object lt1548 {
  def mostSimilar(n: Int, roads: Array[Array[Int]], names: Array[String], targetPath: Array[String]): List[Int] = {
    import scala.collection.mutable

    if (targetPath.isEmpty) Nil else {
      val graph = Array.fill(n)(mutable.ListBuffer.empty[Int])
      roads.foreach(road => {
        graph(road(0)).addOne(road(1))
        graph(road(1)).addOne(road(0))
      })

      val m = targetPath.length
      val dp = Array.fill(m, n)(Int.MaxValue)
      val prev = Array.fill(m, n)(0)
      dp(0).indices.foreach(i => dp(0)(i) = if (names(i) != targetPath(0)) 1 else 0)

      for (i <- 1 until m; v <- 0 until n; u <- graph(v)) {
        if (dp(i - 1)(u) < dp(i)(v)) {
          dp(i)(v) = dp(i - 1)(u) + (if (names(v) != targetPath(i)) 1 else 0)
          prev(i)(v) = u
        }
      }

      val path = mutable.ListBuffer.empty[Int]
      val end = dp.last.zipWithIndex.minBy(_._1)._2
      path.addOne(end)
      for (i <- m - 1 to 1 by -1) {
        path.addOne(prev(i)(path.last))
      }
      path.reverse.toList
    }
  }
}
