// https://leetcode.com/problems/sqrtx/submissions/
object lt69 {
  def mySqrt(x: Int): Int = {
    var lo = 0
    var hi = x

    while (lo <= hi) {
      val mi = lo + (hi - lo) / 2
      val num = mi * mi.toLong
      if (num < x) lo = mi + 1
      else if (num == x) return mi
      else hi = mi - 1
    }
    hi
  }
}
