// https://leetcode.com/problems/longest-common-subsequence/
object lt1143 {
  def longestCommonSubsequence(text1: String, text2: String): Int = {
    val m = text1.length
    val n = text2.length
    val dp = Array.fill(m + 1, n + 1)(0)

    for (i <- 1 to m; j <-  1 to n) {
      if (text1(i - 1) == text2(j - 1)) dp(i)(j) = dp(i - 1)(j - 1) + 1
      else dp(i)(j) = dp(i - 1)(j) max dp(i)(j - 1)
    }
    dp.last.last
  }
}
