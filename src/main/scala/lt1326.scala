// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
object lt1326 {
  def minTaps(n: Int, ranges: Array[Int]): Int = {
    val xx = Array.fill(n + 1)(0)
    ranges.indices.foreach(i => {
      val left = 0 max (i - ranges(i))
      val right = n min (i + ranges(i))
      xx(left) = xx(left) max (right - left)
    })
    println(xx.toList)
    var step = 0
    var curEnd = 0
    var curFarthest = 0
    for (i <- 0 until n) {
      if (i > curFarthest)
        return -1

      curFarthest = curFarthest max (i + xx(i))
      if (i == curEnd) {
        step += 1
        curEnd = curFarthest
      }
    }
    if (curFarthest >= n) step else -1
  }

  def main(args: Array[String]): Unit = {
    println(minTaps(25, Array(3,0,1,5,4,1,4,2,4,4,3,3,3,0,3,2,5,1,5,5,2,3,1,0,2,4)))
  }
}
