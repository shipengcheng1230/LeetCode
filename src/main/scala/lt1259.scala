// https://leetcode.com/problems/handshakes-that-dont-cross/
object lt1259 {
  def numberOfWays(num_people: Int): Int = {
    val mod = (1e9 + 7).toLong
    val dp = Array.fill(num_people / 2 + 1)(0.toLong)
    dp(0) = 1
    for (k <- 1 to num_people / 2; i <- 0 until k) {
      dp(k) = (dp(k) + dp(i) * dp(k - 1 - i)) % mod
    }
    dp(num_people / 2).toInt
  }
}
