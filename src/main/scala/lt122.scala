// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
object lt122 {
  def maxProfit(prices: Array[Int]): Int = {
    prices.indices.tail.foldLeft(0)((acc, i) =>
      if (prices(i) > prices(i - 1)) acc + prices(i) - prices(i - 1) else acc)
  }
}
