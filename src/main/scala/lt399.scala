object lt399 {

  def calcEquation(equations: List[List[String]], values: Array[Double], queries: List[List[String]]): Array[Double] = {
    import scala.collection.mutable.{Queue, Set, Map}

    val graph = Map.empty[String, Set[(String, Double)]]
    equations.toArray.zip(values).foreach(x => {
      graph.getOrElseUpdate(x._1.head, Set.empty[(String, Double)]).addOne(x._1.last, x._2)
      graph.getOrElseUpdate(x._1.last, Set.empty[(String, Double)]).addOne(x._1.head, 1 / x._2)
    })

    def findPath(query: List[String]): Double = {
      val List(b, e) = query
      if (graph.contains(b) && graph.contains(e)) {
        val q = Queue.empty[(String, Double)].enqueue((b, 1.0))
        val visited = Set.empty[String]
        while (q.nonEmpty) {
          val x = q.dequeue()
          if (x._1 == e) return x._2
          visited.addOne(x._1)
          graph(x._1).foreach(y => if (!visited.contains(y._1)) q.enqueue((y._1, y._2 * x._2)))
        }
        -1
      } else -1
    }

    queries.map(findPath).toArray
  }
}
