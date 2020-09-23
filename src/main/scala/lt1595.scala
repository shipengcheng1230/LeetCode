// https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/
object lt1595 {
  def connectTwoGroups(cost: List[List[Int]]): Int = {
    val m = cost.length
    val n = cost.head.length
    val mask = 1 << m
    var dp = Array.fill(mask)(Int.MaxValue)
    dp(0) = 0
    for (i <- 0 until n) {
      val tmp = Array.fill(mask)(Int.MaxValue)
      for (k <- 0 until mask; j <- 0 until m) {
        val msk = k | (1 << j)
        if (dp(k) != Int.MaxValue)
          tmp(msk) = tmp(msk) min (dp(k) + cost(j)(i))
        if ((k & (1 << j)) == 0 && tmp(k) != Int.MaxValue)
          tmp(msk) = tmp(msk) min (tmp(k) + cost(j)(i))
      }
      dp = tmp
    }
    dp.last
  }
}
