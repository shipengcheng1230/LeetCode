// https://leetcode.com/problems/divide-chocolate/
object lt1231 {
  def maximizeSweetness(sweetness: Array[Int], K: Int): Int = {
    import scala.util.control.Breaks._

    var left = 1
    var right = 1e9.toInt / (K + 1)
    while (left < right) {
      val mid = (left + right + 1) / 2
      var cur = 0
      var cuts = 0
      breakable {
        for (sweet <- sweetness) {
          cur += sweet
          if (cur >= mid) {
            cuts += 1
            cur = 0
            if (cuts > K) break()
          }
        }
      }
      if (cuts > K) left = mid
      else right = mid - 1
    }
    left
  }
}
