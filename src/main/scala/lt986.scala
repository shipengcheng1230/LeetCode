// https://leetcode.com/problems/interval-list-intersections/
object lt986 {
  def intervalIntersection(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
    var (i, j) = (0, 0)
    val ans = scala.collection.mutable.ListBuffer.empty[Array[Int]]
    while (i < A.length && j < B.length) {
      val lo = A(i)(0) max B(j)(0)
      val hi = A(i)(1) min B(j)(1)
      if (lo <= hi) {
        ans.addOne(Array(lo, hi))
      }
      if (A(i)(1) < B(j)(1)) i += 1
      else j += 1
    }
    ans.toArray
  }
}
