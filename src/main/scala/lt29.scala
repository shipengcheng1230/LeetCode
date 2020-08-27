// https://leetcode.com/problems/divide-two-integers/
object lt29 {
  def divide(dividend: Int, divisor: Int): Int = {
    val HALF_INT_MIN = -1073741824
    if (dividend == Int.MinValue && divisor == -1)
      return Int.MaxValue

    var negative = 2
    var d1 = if (dividend > 0) {negative -= 1; -dividend} else dividend
    var d2 = if (divisor > 0) {negative -= 1; -divisor} else divisor

    var highestDouble = d2
    var highestPowerOfTwo = -1
    while (highestDouble >= HALF_INT_MIN && d1 <= highestDouble + highestDouble) {
      highestPowerOfTwo += highestPowerOfTwo
      highestDouble += highestDouble
    }

    var quotient = 0
    while (d1 <= d2) {
      if (d1 <= highestDouble) {
        quotient += highestPowerOfTwo
        d1 -= highestDouble
      }
      highestDouble >>= 1
      highestPowerOfTwo >>= 1
    }

    if (negative != 1) -quotient else quotient
  }

  def main(args: Array[String]): Unit = {
    println(divide(10, 3))
  }
}
