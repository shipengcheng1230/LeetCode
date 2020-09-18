// https://leetcode.com/problems/parallel-courses/
object lt1136 {
  def minimumSemesters(N: Int, relations: Array[Array[Int]]): Int = {
    import scala.collection.mutable

    val graph = Array.fill(N + 1)(mutable.ListBuffer.empty[Int])
    val visited = Array.fill(N + 1)(0)
    val depth = Array.fill(N + 1)(1)

    relations.foreach(r => graph(r(0)).addOne(r(1)))

    def dfs(i: Int): Boolean = {
      if (visited(i) == 1) true
      else if (visited(i) == -1) false
      else {
        visited(i) = -1
        graph(i).foreach(j => {
          if (!dfs(j)) return false
          depth(i) = depth(i) max (1 + depth(j))
        })
        visited(i) = 1
        true
      }
    }

    if (graph.tail.indices.forall(dfs)) depth.max else -1
  }
}
