// https://leetcode.com/problems/stone-game-iv/
object lt1510 {
  def winnerSquareGame(n: Int): Boolean = {
    val memo = Array.fill(n + 1)(-1)
    memo(0) = 0
    memo(1) = 1

    def dfs(x: Int): Boolean = {
      if (memo(x) != -1) memo(x) == 1
      else {
        val ans = !(1 to math.sqrt(x).floor.toInt).forall(k => {
          dfs(x - k * k)
        })
        memo(x) = if (ans) 1 else 0
        ans
      }
    }

    dfs(n)
  }

  def winnerSquareGame2(n: Int): Boolean = {
    val dp = Array.fill(n + 1)(false)
    for (i <- 0 to n) {
      if (!(dp(i))) {
        var k = 1
        while (i + k * k <= n) {
          dp(i + k * k) = true
          k += 1
        }
      }
    }
    dp(n)
  }

  def main(args: Array[String]): Unit = {
    print(winnerSquareGame(5))
  }
}
