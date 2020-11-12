// https://leetcode.com/problems/shortest-distance-to-target-color/
object lt1182 {
  def shortestDistanceColor(colors: Array[Int], queries: Array[Array[Int]]): List[Int] = {
    val n = colors.length
    val max = 50001
    val dp = Array.fill(n, 3)(max)
    dp(0)(colors(0) - 1) = 0
    for (i <- 1 until n) {
      dp(i)(colors(i) - 1) = 0
      (0 until 3).foreach(j => dp(i)(j) = math.min(dp(i - 1)(j) + 1, dp(i)(j)))
    }
    for (i <- n - 2 to 0 by -1; j <- 0 until 3)
      dp(i)(j) = math.min(dp(i + 1)(j) + 1, dp(i)(j))

    queries.map(q => dp(q(0))(q(1) - 1)).map(x => if (x >= max) -1 else x).toList
  }
}
