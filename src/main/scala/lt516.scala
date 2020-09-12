// https://leetcode.com/problems/longest-palindromic-subsequence/description/
object lt516 {
  def longestPalindromeSubseq(s: String): Int = {
    val n = s.length
    val dp = Array.fill(n, n)(0)
    // dp(i)(i) = 1, self palindrome
    (0 until n).foreach(i => dp(i)(i) = 1)
    for (i <- s.length - 1 to 0 by -1; j <- i + 1 until s.length) {
      if (s(i) == s(j))
        dp(i)(j) = dp(i + 1)(j - 1) + 2
      else
        dp(i)(j) = math.max(dp(i + 1)(j), dp(i)(j - 1))
    }
    dp(0)(n)
  }
}
