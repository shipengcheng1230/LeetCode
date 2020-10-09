// https://leetcode.com/problems/count-number-of-teams/submissions/
object lt1395 {
  def numTeams(rating: Array[Int]): Int = {
    val n = rating.length
    var ans = 0
    for (i <- 1 until n - 1) {
      val lt = Array.ofDim[Int](2)
      val gt = Array.ofDim[Int](2)
      for (j <- 0 until n; if i != j) {
        val index = if (j < i) 0 else 1
        if (rating(j) > rating(i)) gt(index) += 1
        else lt(index) += 1
      }
      ans += lt(0) * gt(1) + lt(1) * gt(0)
    }
    ans
  }
}
