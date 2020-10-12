// https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/
object lt1617 {
  def countSubgraphsForEachDiameter(n: Int, edges: Array[Array[Int]]): Array[Int] = {
    import scala.collection.mutable.ListBuffer

    val graph = Array.fill(16)(ListBuffer.empty[Int])
    edges.foreach(e => {
      graph(e(0)).append(e(1))
      graph(e(1)).append(e(0))
    })
    var maxDiameter = 0

    val ans = Array.fill(n - 1)(0)
    for (i <- 1 until 1 << n) {
      val subset = (for (j <- 0 until n; if (i & (1 << j)) != 0) yield (j + 1)).toSet
      val count = edges.foldLeft(0)((acc, e) => {
        if (subset.contains(e(0)) && subset.contains(e(1))) acc + 1 else acc
      })
      if (subset.size > 1 && subset.size == count + 1) {
        maxDiameter = 0
        dfs(subset.head, -1, subset)
        ans(maxDiameter - 1) += 1
      }
    }

    def dfs(start: Int, parent: Int, subtree: Set[Int]): Int = {
      var max1 = 0
      var max2 = 0

      for (child <- graph(start); if child != parent && subtree.contains(child)) {
        val childSize = 1 + dfs(child, start, subtree)
        if (childSize > max1) {
          max2 = max1
          max1 = childSize
        } else if (childSize > max2) {
          max2 = childSize
        }
        maxDiameter = maxDiameter max (max1 + max2)
      }
      max1
    }

    ans
  }
}
