// https://leetcode.com/problems/valid-palindrome-iii/
object lt1216 {
  def isValidPalindrome(s: String, k: Int): Boolean = {
    val n = s.length
    val dp = Array.fill(n + 1, n + 1)(0)
    for (d <- 0 until n; i <- 1 to n - d) {
      val j = i + d
      if (i == j) dp(i)(j) = 1
      else if (s(i - 1) == s(j - 1)) dp(i)(j) = dp(i + 1)(j - 1) + 2
      else dp(i)(j) = dp(i + 1)(j) max dp(i)(j - 1)
    }
    n - dp(1)(n) <= k
  }
}
