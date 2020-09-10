// https://leetcode.com/problems/dice-roll-simulation/
object lt1223 {
  def dieSimulator(n: Int, rollMax: Array[Int]): Int = {
    val mod = (1e9 + 7).toInt
    val dp = Array.fill(n + 1, 7)(1)
    dp(1)(6) = 6
    for (i <- 2 to n) {
      var total = 0
      for (j <- 0 until 6) {
        dp(i)(j) = dp(i - 1)(6)
        if (i - rollMax(j) == 1) dp(i)(j) -= 1
        if (i - rollMax(j) >= 2) {
          val reduction = dp(i - rollMax(j) - 1)(6) - dp(i - rollMax(j) - 1)(j)
          dp(i)(j) = ((dp(i)(j) - reduction) % mod + mod) % mod
        }
        total = (total + dp(i)(j)) % mod
      }
      dp(i)(6) = total
    }
    dp(n)(6)
  }
}
