// https://leetcode.com/problems/triangle/
object lt120 {
  def minimumTotal(triangle: List[List[Int]]): Int = {
    val tri = triangle.map(_.toArray).toArray
    val n = tri.length
    val dp = tri.last
    for {
      i <- n - 2 to 0 by -1
      j <- 0 to i
    } {
      dp(j) = tri(i)(j) + math.min(dp(j), dp(j + 1))
    }
    dp(0)
  }
}
