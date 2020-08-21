// https://leetcode.com/problems/meeting-scheduler/
object lt1229 {
  def minAvailableDuration(slots1: Array[Array[Int]], slots2: Array[Array[Int]], duration: Int): List[Int] = {
    var i = 0
    var j = 0
    slots1.sortInPlaceBy(_(0))
    slots2.sortInPlaceBy(_(0))
    while (i < slots1.length && j < slots2.length) {
      val start = slots1(i)(0) max slots2(j)(0)
      val end = slots1(i)(1) min slots2(j)(1)
      if (end - start >= duration)
        return List(start, start + duration)
      if (slots1(i)(0) < slots2(j)(0)) i += 1 else j += 1
    }
    List.empty[Int]
  }

  def main(args: Array[String]): Unit = {
    println(minAvailableDuration(
      Array(Array(10,50), Array(60,120), Array(140,210)),
      Array(Array(0,15), Array(60,70)),
      8
    ))
  }
}
