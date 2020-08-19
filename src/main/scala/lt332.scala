// https://leetcode.com/problems/reconstruct-itinerary/
object lt332 {
  def findItinerary(tickets: List[List[String]]): List[String] = {

    type Graph = Map[String, List[String]]
    val graph: Graph = tickets.groupMap(_.head)(_.last).view.mapValues(_.sorted).toMap

    def dfs(graph: Graph, initialPoint: String): (Graph, Seq[String]) = {
      graph.get(initialPoint) match {
        case None => (graph, Seq(initialPoint))
        case Some(Nil) => throw new IllegalStateException("Graphs should not have empty lists")
        case Some(neighbor :: neighbors) =>
          val updatedGraph =
            if (neighbors.isEmpty) graph.removed(initialPoint)
            else graph.updated(initialPoint, neighbors)
          val (newGraph, lastSeq) = dfs(updatedGraph, neighbor)
          val (betterGraph, remainingSeq) = dfs(newGraph, initialPoint)
          (betterGraph, remainingSeq ++ lastSeq)
      }
    }

    dfs(graph, "JFK")._2.toList
  }

}
