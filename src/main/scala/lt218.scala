// https://leetcode.com/problems/the-skyline-problem/
object lt218 {
  def getSkyline(buildings: Array[Array[Int]]): List[List[Int]] = {

    def toCriticalPoints(buildings: Array[Array[Int]]): List[(Int, Int)] = {
      buildings.flatMap(x => List(x(0) -> x(2), x(1) -> x(2))).sortBy(_._1).toList
    }

    def filterSameHeight(points: List[List[Int]]): List[List[Int]] = points match {
      case Nil => Nil
      case h :: n :: t if h(1) == n(1) => filterSameHeight(h :: t)
      case h :: t => h :: filterSameHeight(t)
    }

    filterSameHeight(toCriticalPoints(buildings).map(cp => {
      val overlapping = buildings.filter(b => b(0) <= cp._1 && b(1) > cp._1)
      val height = if (overlapping.isEmpty) 0 else overlapping.map(_(2)).max
      List(cp._1, height)
    }))
  }
}
