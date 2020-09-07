// https://leetcode.com/problems/ugly-number-ii/
object lt264 {
  def nthUglyNumber(n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else {
      var t2 = 0
      var t3 = 0
      var t5 = 0
      val k = Array.ofDim[Int](n)
      k(0) = 1
      for (i <- 1 until n) {
        k(i) = (k(t2) * 2) min (k(t3) * 3) min (k(t5) * 5)
        if (k(i) == k(t2) * 2) t2 += 1
        if (k(i) == k(t3) * 3) t3 += 1
        if (k(i) == k(t5) * 5) t5 += 1
      }
      k.last
    }
  }
}
