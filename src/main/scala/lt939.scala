// https://leetcode.com/problems/minimum-area-rectangle/
object lt939 {
  def minAreaRect(points: Array[Array[Int]]): Int = {
    import scala.collection.mutable.Map

    val map = points.groupMap(_(0))(_(1))
    var ans = Int.MaxValue
    val visited = Map.empty[Int, Int]
    for (k <- map.keys.toArray.sorted) {
      val cols = map(k).sorted
      for {
        i <- cols.indices
        j <- i + 1 until cols.length
      } {
        val c1 = cols(i)
        val c2 = cols(j)
        val code = c1 * 40001 + c2
        if (visited.contains(code)) {
          ans = ans min ((c2 - c1) * (k - visited(code)))
        }
        visited.update(code, k)
      }
    }
    if (ans == Int.MaxValue) 0 else ans
  }
}
