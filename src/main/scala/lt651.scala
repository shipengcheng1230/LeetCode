// https://leetcode.com/problems/4-keys-keyboard/
object lt651 {
  def maxA(N: Int): Int = {
    val dp = Array.fill(N + 1)(0)
    for (k <- 1 to N) {
      dp(k) = dp(k - 1) + 1
      for (x <- 0 until k) {
        dp(k) = dp(k) max (dp(x) * (k - x - 1))
      }
    }
    dp.last
  }
}
