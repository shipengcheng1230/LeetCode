// https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/
object lt1599 {
  def minOperationsMaxProfit(customers: Array[Int], boardingCost: Int, runningCost: Int): Int = {
    var profit = 0
    var maxProfit = 0
    var remaining = 0
    var ans = -1
    customers.zipWithIndex.foreach { case (c, i) => {
      val taken = 4 min (c + remaining)
      remaining = 0 max (c - 4 + remaining)
      profit += taken * boardingCost - runningCost
      if (profit > maxProfit) {
        maxProfit = profit
        ans = i + 1
      }
    }}
    while (remaining > 0) {
      val taken = 4 min (remaining)
      remaining -= taken
      profit += taken * boardingCost - runningCost
      if (profit > maxProfit) {
        maxProfit = profit
        ans += 1
      }
    }
    ans
  }
}
