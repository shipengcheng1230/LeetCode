// https://leetcode.com/problems/decode-ways-ii/
object lt639 {
  def numDecodings(s: String): Int = {
    val mod = 1000000007
    var first = 1
    var second = if (s(0) == '*') 9 else if (s(0) == '0') 0 else 1
    for (i <- 1 until s.length) {
      val temp = second
      if (s(i) == '*') {
        second = 9 * second
        if (s(i - 1) == '1') second = (second + first * 9) % mod
        else if (s(i - 1) == '2') second = (second + 6 * first) % mod
        else if (s(i - 1) == '*') second = (second + 15 * first) % mod
      } else {
        second = if (s(i) == '0') 0 else second
        if (s(i - 1) == '1') second = (second + first) % mod
        else if (s(i - 1) == '2' && s(i) <= '6') second = (second + first) % mod
        else if (s(i - 1) == '*') second = (second + (if (s(i) <= '6') 2 else 1) * first) % mod
      }
      first = temp
    }
    second
  }
}
