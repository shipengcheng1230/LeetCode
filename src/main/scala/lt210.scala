// https://leetcode.com/problems/course-schedule-ii/
import scala.annotation.tailrec

object lt210 {
  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {

    if (prerequisites.isEmpty) return (0 until numCourses).toArray

    val inDegreeMap = prerequisites.foldLeft(Map.empty[Int, Set[Int]].withDefaultValue(Set.empty[Int])) {
      case (acc, Array(dest, src)) => acc + (src -> acc(src)) + (dest -> (acc(dest) incl src))
    }

    @tailrec
    def topologySort(curr: Map[Int, Set[Int]], sorted: Array[Int]): Option[Array[Int]] = {
      val (zero, nonzero) = curr.partition(_._2.isEmpty)
      (zero.isEmpty, nonzero.isEmpty) match {
        case (true, true) => Some(sorted)
        case (true, false) => None
        case _ =>
          topologySort(nonzero.view.mapValues(_ removedAll zero.keySet).toMap, sorted ++ zero.keys)
      }
    }

    topologySort(inDegreeMap, Array.empty[Int]) match {
      case Some(x) => ((0 until numCourses).toSet -- x).toArray ++ x
      case None => Array.empty[Int]
    }
  }
}
