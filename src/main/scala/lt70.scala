// https://leetcode.com/problems/climbing-stairs/
object lt70 {
  def climbStairs(n: Int): Int = {
    if (n == 1) 1 else {
      val dp = Array.fill(n + 1)(0)
      dp(1) = 1
      dp(2) = 2
      (3 to n).foreach(i => dp(i) = dp(i - 1) + dp(i - 2))
      dp(n)
    }
  }
}
