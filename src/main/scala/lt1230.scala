// https://leetcode.com/problems/toss-strange-coins/
object lt1230 {
  def probabilityOfHeads(prob: Array[Double], target: Int): Double = {
    val n = prob.length
    val dp = Array.fill(target + 1)(0.0)
    // dp(c)(k) = dp(c - 1)(k - 1) * p + dp(c - 1)(k) * (1 - p)
    dp(0) = 1.0
    prob.indices.foreach(i => {
      for (k <- math.min(i + 1, target) to 0 by -1) {
        dp(k) = (if (k > 0) dp(k - 1) else 0) * prob(i) + dp(k) * (1 - prob(i))
      }
    })
    dp(target)
  }
}
