object lt1192 {
  def criticalConnections(n: Int, connections: List[List[Int]]): List[List[Int]] = {

    import scala.collection.mutable

    val graph = (0 to n).map(_ => mutable.ListBuffer.empty[Int])
    connections.foreach(c => {
      graph(c(0)).addOne(c(1))
      graph(c(1)).addOne(c(0))
    })

    val lows = Array.fill(n)(n)
    val critical = mutable.ListBuffer.empty[List[Int]]

    def dfs(node: Int, discovery_time: Int, parent: Int): Int = {
      if (lows(node) == n) {
        lows(node) = discovery_time
        graph(node).foreach(neighbor => {
          if (neighbor != parent) {
            val expected_discovery_time_of_child = discovery_time + 1
            val actual_discovery_time_of_child = dfs(neighbor, expected_discovery_time_of_child, node)
            if (actual_discovery_time_of_child >= expected_discovery_time_of_child) {
              critical.append(List(node, neighbor))
            }
            lows(node) = lows(node) min actual_discovery_time_of_child
          }
        })
      }
      lows(node)
    }

    dfs(n-1, 0, -1)
    critical.toList
  }
}
