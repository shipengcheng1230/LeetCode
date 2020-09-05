// https://leetcode.com/problems/maximum-vacation-days/
object lt568 {
  def maxVacationDays(flights: Array[Array[Int]], days: Array[Array[Int]]): Int = {
    val n = flights.length
    val k = days.head.length
    var dp = Array.fill(n)(Int.MinValue)
    dp(0) = 0
    for (i <- 0 until k) {
      val temp = Array.fill(n)(Int.MinValue)
      for (j <- 0 until n; k <- 0 until n) {
        if (j == k || flights(k)(j) == 1)
          temp(j) = math.max(temp(j), dp(k) + days(j)(i))
      }
      dp = temp
    }
    dp.max
  }
}
