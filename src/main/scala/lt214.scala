// https://leetcode.com/problems/shortest-palindrome/
object lt214 {
  def shortestPalindrome(s: String): String = {
    val n = s.length
    val rev = s.reverse
    val sn = s + '#' + rev
    val nn = sn.length
    val f = Array.fill(nn)(0)
    for (i <- 1 until nn) {
      var t = f(i - 1)
      while (t > 0 && sn(i) != sn(t))
        t = f(t - 1)
      if (sn(i) == sn(t))
        t += 1
      f(i) = t
    }
    rev.substring(0, n - f(nn - 1)) + s
  }
}
