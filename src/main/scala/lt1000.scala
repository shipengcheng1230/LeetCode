// https://leetcode.com/problems/minimum-cost-to-merge-stones/
object lt1000 {
  // similar to balloon interval
  def mergeStones(stones: Array[Int], K: Int): Int = {
    val len = stones.length
    if ((len - 1) % (K - 1) != 0) -1
    else {
      val prefixSum = stones.scanLeft(0)(_ + _)
      // Minimum cost merging piles from i to j to k pile
      val dp =  Array.ofDim[Int](len + 1, len + 1, K + 1)
      for {
        i <- 1 to len
        j <- 1 to len
        k <- 1 to K
      } {
        dp(i)(j)(k) = Int.MaxValue
      }
      for (i <- 1 to len)
        dp(i)(i)(1) = 0

      for (l <- 2 to len; i <- 1 to len - l + 1) {
        val j = i + l - 1
        for (k <- 2 to K; t <- i until j) {
          if (dp(i)(t)(k - 1) != Int.MaxValue && dp(t + 1)(j)(1) != Int.MaxValue) {
            // left part to k - 1 piles, right part to 1 pile, then merge
            dp(i)(j)(k) = math.min(dp(i)(j)(k), dp(i)(t)(k - 1) + dp(t + 1)(j)(1))
          }
        }

        if (dp(i)(j)(K) != Int.MaxValue)
          dp(i)(j)(1) = dp(i)(j)(K) + prefixSum(j) - prefixSum(i - 1)
      }
      dp(1)(len)(1)
    }
  }

  def main(args: Array[String]): Unit = {
    println(mergeStones(Array(6,4,9,3,1), 3))
  }
}
