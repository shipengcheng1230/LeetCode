// https://leetcode.com/problems/maximum-number-of-visible-points/
object lt1610 {
  def visiblePoints(points: List[List[Int]], angle: Int, location: List[Int]): Int = {
    import scala.collection.mutable.ArrayBuffer

    var same = 0
    var ans = 0
    val algs = ArrayBuffer.empty[Double]
    points.foreach(pt => {
      val dx = pt.head - location.head
      val dy = pt.last - location.last
      if (dx == 0 && dy == 0) same += 1
      else {
        val alg = math.toDegrees(math.atan2(dy, dx))
        algs.append(alg)
        algs.append(alg + 360)
      }
    })
    algs.sortInPlace()
    var i = 0
    var j = 0
    while (i < algs.length) {
      while (algs(i) - algs(j) > angle) j += 1
      ans = ans max (i - j + 1)
      i += 1
    }
    ans + same
  }
}
