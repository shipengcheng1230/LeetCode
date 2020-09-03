// https://leetcode.com/problems/number-of-digit-one/
object lt233 {
  def countDigitOne(n: Int): Int = {
    var ones = 0
    var m = 1
    var r = 1
    var x = n
    while (x > 0) {
      ones += (x + 8) / 10 * m + (if (x % 10 == 1) r else 0)
      r += x % 10 * m
      m *= 10
      x /= 10
    }
    ones
  }
}
