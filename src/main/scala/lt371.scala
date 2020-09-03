// https://leetcode.com/problems/sum-of-two-integers/
object lt371 {
  def getSum(a: Int, b: Int): Int = {
    var x = a
    var y = b
    while (y != 0) {
      val ans = x ^ y
      val carry = (x & y) << 1
      x = ans
      y = carry
    }
    x
  }
}
