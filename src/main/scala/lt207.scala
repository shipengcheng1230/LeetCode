// https://leetcode.com/problems/course-schedule/
object lt207 {
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    if (prerequisites.isEmpty) true
    else {
      val inDegreeMap = prerequisites.foldLeft(Map.empty[Int, Set[Int]])((acc, x) => {
        val Array(src, dest) = x
        acc + (dest -> (acc.getOrElse(dest, Set()) + src)) + (src -> acc.getOrElse(src, Set()))
      })

      @scala.annotation.tailrec
      def tsort(inDegree: Map[Int, Set[Int]]): Boolean = {
        val (zero, nonzero) = inDegree.partition(_._2.isEmpty)

        (zero.isEmpty, nonzero.isEmpty) match {
          case (true, true) => true
          case (true, false) => false
          case _ => tsort(nonzero.view.mapValues(_.removedAll(zero.keys)).toMap)
        }
      }

      tsort(inDegreeMap)
    }
  }
}
