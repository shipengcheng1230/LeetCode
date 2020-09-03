// https://leetcode.com/problems/digit-count-in-range/
object lt1067 {
  def digitsCount(d: Int, low: Int, high: Int): Int = {

    def count(d: Int, n: Int): Int = {
      var cnt = 0
      var m = 1
      while (m <= n) {
        val a = n / m
        val b = n % m
        cnt += (a + 9 - d) / 10 * m + (if (a % 10 == d) b + 1 else 0)
        if (d == 0) cnt -= m
        m *= 10
      }
      cnt
    }

    count(d, high) - count(d, low - 1)
  }
}
