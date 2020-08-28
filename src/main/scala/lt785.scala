// https://leetcode.com/problems/is-graph-bipartite/
object lt785 {
  def isBipartite(graph: Array[Array[Int]]): Boolean = {
    import scala.collection.mutable

    val colors = Array.fill(graph.length)(-1)
    graph.indices.foreach(i => {
      if (colors(i) == -1) {
        val stack = mutable.Stack.empty[Int]
        stack.push(i)
        colors(i) = 0
        while (stack.nonEmpty) {
          val node = stack.pop()
          graph(node).foreach(nei => {
            if (colors(nei) == -1) {
              stack.push(nei)
              colors(nei) = colors(node) ^ 1
            } else if (colors(nei) == colors(node)) return false
          })
        }
      }
    })
    true
  }
}
