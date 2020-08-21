// https://leetcode.com/problems/minimum-time-difference/
object lt539 {
  def findMinDifference(timePoints: List[String]): Int = {
    val t = timePoints.sorted
    val t2 = t.last :: t
    t2.map(x => {
      val Array(hour, min) = x.split(":")
      hour.toInt * 60 + min.toInt
    }).sliding(2, 1).map(x => {
      val hm = math.abs(x.last - x.head)
      (1440 - hm) min hm
    }).min
  }

  def main(args: Array[String]): Unit = {
    println(findMinDifference(List("23:59","00:00")))
  }
}
