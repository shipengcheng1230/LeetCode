// https://leetcode.com/problems/minimum-cost-to-merge-stones/
object lt1000 {
  def mergeStones(stones: Array[Int], K: Int): Int = {

    if (stones.isEmpty) 0
    else {
      val len = stones.length
      val dp = Array.fill(len + 1, len + 1)(0)
      val prefixSum = stones.scanLeft(0)(_ + _)
      for (l <- 2 to len; i <- 1 to len - l + 1) {
        val j = i + l - 1
        dp(i)(j) = Int.MaxValue
        val sum = prefixSum(j) - prefixSum(i - 1)
        for (k <- i until j)
          dp(i)(j) = dp(i)(j) min (dp(i)(k) + dp(k + 1)(j) + sum)
      }
      dp(1)(len)
    }
  }
}
