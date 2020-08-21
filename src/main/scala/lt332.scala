// https://leetcode.com/problems/reconstruct-itinerary/
object lt332 {
  def findItinerary(tickets: List[List[String]]): List[String] = {

    import scala.collection.mutable

    val graph = tickets
      .groupMap(_.head)(_.last)
      .view
      .mapValues(_.sorted.to(mutable.ArrayDeque))
      .toMap
    val ans = mutable.ArrayDeque.empty[String]

    def dfs(origin: String): Unit = {
      if (graph.contains(origin)) {
        val dests = graph(origin)
        while (dests.nonEmpty) {
          val dest = dests.removeHead()
          dfs(dest)
        }
      }
      ans.prepend(origin)
    }

    dfs("JFK")
    ans.toList
  }

}
