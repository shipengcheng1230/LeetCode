// https://leetcode.com/problems/best-team-with-no-conflicts/
object lt1626 {
  def bestTeamScore(scores: Array[Int], ages: Array[Int]): Int = {
    val n = scores.length
    val dp = Array.fill(n)(0)
    val candidate = ages.zip(scores).sortBy(x => (x._1, x._2))
    dp(0) = candidate(0)._2
    for (i <- 1 until n) {
      dp(i) = candidate(i)._2
      for (j <- 0 until i; if candidate(j)._2 <= candidate(i)._2) {
        dp(i) = dp(i) max (candidate(i)._2 + dp(j))
      }
    }
    dp.max
  }
}
