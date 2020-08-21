// https://leetcode.com/problems/max-points-on-a-line/
object lt149 {
  def maxPoints(points: Array[Array[Int]]): Int = {
    import scala.annotation.tailrec

    @tailrec
    def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)

    if (points.length <= 2) points.length
    else {
      val map = scala.collection.mutable.Map.empty[(Int, Int), Int]
      var ans = 0
      points.indices.foreach(i => {
        map.clear()
        var overlap = 0
        var curmax = 0
        (i + 1 until points.length).foreach(j => {
          var dx = points(j)(0) - points(i)(0)
          var dy = points(j)(1) - points(i)(1)
          if (dx == 0 && dy == 0)
            overlap += 1
          else {
            val c = gcd(dx, dy)
            dx /= c
            dy /= c
            map.update((dx, dy), map.getOrElse((dx, dy), 0) + 1)
            curmax = curmax max map((dx, dy))
          }
        })
        ans = ans max (curmax + overlap + 1)
      })
      ans
    }
  }

  def main(args: Array[String]): Unit = {
    println(maxPoints(Array(Array(1,1), Array(3,2), Array(5,3), Array(4,1), Array(2,3), Array(1,4))))
  }
}
