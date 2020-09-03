// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
object lt309 {
  def maxProfit(prices: Array[Int]): Int = {
    val mp = Array.fill(prices.length + 2)(0)
    prices.indices.reverse.foreach(i => {
      var c1 = 0
      for (sell <- i + 1 until prices.length) {
        val profit = prices(sell) - prices(i) + mp(sell + 2)
        c1 = c1 max profit
      }
      val c2 = mp(i + 1)
      mp(i) = c1 max c2
    })
    mp(0)
  }
}
