// https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
object lt562 {
  def longestLine(M: Array[Array[Int]]): Int = {
    import scala.collection.mutable.Map

    val row = Map.empty[Int, Int]
    val col = Map.empty[Int, Int]
    val adg = Map.empty[Int, Int]
    val ddg = Map.empty[Int, Int]
    var ans = 0

    for (i <- M.indices; j <- M.head.indices) {
      if (M(i)(j) == 0) {
        row.update(i, 0)
        col.update(j, 0)
        adg.update(j + i, 0)
        ddg.update(j - i, 0)
      } else {
        row.update(i, row.getOrElse(i, 0) + M(i)(j))
        col.update(j, col.getOrElse(j, 0) + M(i)(j))
        adg.update(j + i, adg.getOrElse(j + i, 0) + M(i)(j))
        ddg.update(j - i, ddg.getOrElse(j - i, 0) + M(i)(j))
        ans = ans max row(i) max col(j) max adg(j + i) max ddg(j - i)
      }

    }
    ans
  }
}
