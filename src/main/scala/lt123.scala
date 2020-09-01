// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
object lt123 {
  def maxProfit(prices: Array[Int]): Int = {
    var t1cost = Int.MaxValue
    var t2cost = Int.MaxValue
    var t1profit = 0
    var t2profit = 0
    for (price <- prices) {
      t1cost = t1cost min price
      t1profit = t1profit max (price - t1cost)
      t2cost = t2cost min (price - t1profit)
      t2profit = t2profit max (price - t2cost)
    }
    t2profit
  }
}
