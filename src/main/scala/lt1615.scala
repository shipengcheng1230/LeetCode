// https://leetcode.com/problems/maximal-network-rank/
object lt1615 {
  def maximalNetworkRank(n: Int, roads: Array[Array[Int]]): Int = {
    import scala.collection.mutable.{Map, Set}

    val graph = Map.empty[Int, Set[Int]]
    roads.foreach(r => {
      graph.getOrElseUpdate(r(0), Set.empty[Int]).addOne(r(1))
      graph.getOrElseUpdate(r(1), Set.empty[Int]).addOne(r(0))
    })
    if (graph.isEmpty) return 0
    var ans = 0
    for {
      x <- graph.keys
      y <- graph.keys
      if x != y
    } {
      val degree = graph(x).size + graph(y).size
      ans = ans max (degree - (if (graph(x).contains(y)) 1 else 0))
    }
    ans
  }
}
