// https://leetcode.com/problems/knight-dialer/
object lt935 {
  def knightDialer(n: Int): Int = {
    val MOD = 1_000_000_007
    val dp = Array.fill(2, 10)(0)
    val moves = Vector(
      Vector(4, 6),
      Vector(6, 8),
      Vector(7, 9),
      Vector(4, 8),
      Vector(0, 3, 9),
      Vector(),
      Vector(0, 1, 7),
      Vector(2, 6),
      Vector(1, 3),
      Vector(2, 4)
    )
    dp(0).indices.foreach(dp(0)(_) = 1)
    (1 until n).foreach(hop => {
      val curr = hop % 2
      val prev = (hop + 1) % 2
      dp(curr).indices.foreach(dp(curr)(_) = 0)
      (0 to 9).foreach(dial => {
        moves(dial).foreach(move => {
          dp(curr)(move) += dp(prev)(dial)
          dp(curr)(move) %= MOD
        })
      })
    })
    dp((n + 1) % 2).reduce((x, y) => (x + y) % MOD)
  }
}
