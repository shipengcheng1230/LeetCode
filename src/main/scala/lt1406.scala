// https://leetcode.com/problems/stone-game-iii/
object lt1406 {
  def stoneGameIII(stoneValue: Array[Int]): String = {
    val n = stoneValue.length
    val dp = Array.fill(n + 1)(0)
    // `dp(n) = 0` denote end of picking, nothing to gain, which is the start condition
    for (i <- n - 1 to 0 by -1) {
      dp(i) = Int.MinValue
      var take = 0
      var k = 0
      while (k < 3 && i + k < n) {
        take += stoneValue(i + k)
        dp(i) = math.max(dp(i), take - dp(i + k + 1))
        k += 1
      }
    }
    dp(0) - 0 match {
      case x if x > 0 => "Alice"
      case 0 => "Tie"
      case _ => "Bob"
    }
  }

  def main(args: Array[String]): Unit = {
    print(stoneGameIII(Array(1,2,3,7)))
  }
}
