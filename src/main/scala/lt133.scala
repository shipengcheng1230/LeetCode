// https://leetcode.com/problems/clone-graph/
object lt133 {

  class Node(var _value: Int) {
    var value: Int = _value
    var neighbors: List[Node] = List()
  }

  val seen = scala.collection.mutable.Map.empty[Node, Node]

  def cloneGraph(graph: Node): Node = {
    if (graph == null) graph
    else {
      if (seen.contains(graph)) seen(graph)
      else {
        val clone = new Node(graph.value)
        seen.update(graph, clone)
        clone.neighbors = graph.neighbors.map(cloneGraph)
        clone
      }
    }
  }
}
