import scala.annotation.tailrec

object lt815 {
  def numBusesToDestination(routes: Array[Array[Int]], S: Int, T: Int): Int = {
    val stop2bus = routes.indices.flatMap(bus => routes(bus).distinct.map(_ -> bus)).groupMap(_._1)(_._2)

    @tailrec
    def helper(num: Int, stops: Set[Int], busesTaken: Set[Int]): Int = {
      if (stops.isEmpty) -1
      else if (stops.contains(T)) num
      else {
        val newBuses = stops.flatMap(stop2bus) -- busesTaken
        helper(num + 1, newBuses.flatMap(routes(_)), busesTaken ++ newBuses)
      }
    }

    helper(0, Set(S), Set())
  }
}
