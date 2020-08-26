// https://leetcode.com/problems/add-binary/
object lt67 {
  import scala.annotation.tailrec

  @tailrec
  def addBinary(a: String, b: String): String = {
    val n = a.length
    val m = b.length
    if (n < m) addBinary(b, a) else {
      val l = m max n
      val sb = new StringBuilder
      var carry = 0
      var j = m - 1
      for { i <- l - 1 to 0 by -1} {
        if (a(i) == '1') carry += 1
        if (j > -1 && b(j) == '1') carry += 1
        j -= 1
        if (carry % 2 == 1) sb.append('1')
        else sb.append('0')

        carry /= 2
      }
      if (carry == 1) sb.append('1')
      sb.reverse.toString()
    }
  }

  def addBinary2(a: String, b: String): String = {
    var x = BigInt(a, 2)
    var y = BigInt(b, 2)
    val zero = BigInt("0", 2)
    var carry: BigInt = 0
    var ans: BigInt = 0
    while (y != zero) {
      ans = x ^ y
      carry = (x & y) << 1
      x = ans
      y = carry
    }
    x.toString(2)
  }

  def main(args: Array[String]): Unit = {
    print(addBinary("1010", "1011"))
  }
}
