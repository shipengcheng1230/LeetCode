// https://leetcode.com/problems/minimum-number-of-refueling-stops/
object lt871 {
  def minRefuelStops(target: Int, startFuel: Int, stations: Array[Array[Int]]): Int = {
    val n = stations.length
    val dp = Array.ofDim[Int](n + 1)
    dp(0) = startFuel
    for (i <- 0 until n; t <- i to 0 by -1) {
      if (dp(t) >= stations(i)(0))
        dp(t + 1) = dp(t + 1) max (dp(t) + stations(i)(1))
    }
    dp.zipWithIndex.find(_._1 >= target).map(_._2).getOrElse(-1)
  }
}
