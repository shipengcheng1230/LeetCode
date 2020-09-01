// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
object lt188 {
  def maxProfit(k: Int, prices: Array[Int]): Int = {
    if (k > prices.length / 2) quickSolve(prices)
    else {
      val t = Array.fill(k + 1, prices.length)(0)
      for (i <- 1 to k) {
        var tmpMax = -prices(0)
        for (j <- 1 until prices.length) {
          t(i)(j) = math.max(t(i)(j - 1), prices(j) + tmpMax)
          tmpMax = math.max(tmpMax, t(i - 1)(j - 1) - prices(j))
        }
      }
      t(k)(prices.length - 1)
    }
  }

  def quickSolve(prices: Array[Int]): Int = {
    if (prices.length < 2) 0 else {
      prices.sliding(2, 1).foldLeft(0)((acc, x) => {
        acc + math.max(0, x(1) - x(0))
      })
    }
  }
}
