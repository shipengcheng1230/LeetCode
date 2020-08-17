// https://leetcode.com/problems/reverse-integer/
object lt7 {
  def reverse(x: Int): Int = {
    var c = math.abs(x)
    var d = 0
    var ans = 0
    while (c > 0) {
      val (a, b) = (c / 10, c % 10)
      if ((Integer.MAX_VALUE - b) / 10 < ans) return 0
      ans = ans * 10 + b
      c = a
      d += 1
    }
    ans * math.signum(x)
  }

  def main(args: Array[String]): Unit = {
    println(reverse(-1234444447))
  }
}
