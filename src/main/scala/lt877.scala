// https://leetcode.com/problems/stone-game/
object lt877 {
  def stoneGame(piles: Array[Int]): Boolean = {
    val n = piles.length
    val dp = Array.fill(n + 2, n + 2)(0)
    for (size <- 1 to n; i <- 0 to n - size) {
      val j = i + size - 1
      val parity = (j + i + n) % 2
      if (parity == 1) {
        dp(i + 1)(j + 1) = math.max(piles(i) + dp(i + 2)(j + 1), piles(j) + dp(i + 1)(j))
      } else {
        dp(i + 1)(j + 1) = math.max(-piles(i) + dp(i + 2)(j + 1), -piles(j) + dp(i + 1)(j))
      }
    }
    dp(1)(n) > 0
  }
}
