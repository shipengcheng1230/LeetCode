// https://leetcode.com/problems/optimize-water-distribution-in-a-village/submissions/
object lt1168 {
  def minCostToSupplyWater(n: Int, wells: Array[Int], pipes: Array[Array[Int]]): Int = {
    import scala.collection.mutable

    val edges = mutable.ListBuffer.empty[Array[Int]]
    val parent = Array.tabulate(n + 1)(identity)
    val rank = Array.fill(n + 1)(0)
    var ans = 0

    wells.zipWithIndex.foreach { case (well, i) =>
      edges.addOne(Array(0, i + 1, well))
    }
    edges.addAll(pipes)

    def find(i: Int): Int = {
      if (parent(i) != i) parent(i) = find(parent(i))
      parent(i)
    }

    def union(x: Int, y: Int, cost: Int): Unit = {
      val px = find(x)
      val py = find(y)
      if (px != py) {
        if (rank(px) > rank(py)) parent(py) = px
        else if (rank(px) < rank(py)) parent(px) = py
        else {
          parent(py) = px
          rank(px) += 1
        }
        ans += cost
      }
    }

    edges.sortBy(_(2)).foreach(edge => {
      union(edge(0), edge(1), edge(2))
    })

    ans
  }
}
