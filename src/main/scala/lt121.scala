import scala.annotation.tailrec

object lt121 {
  def maxProfit(prices: Array[Int]): Int = {
    @tailrec
    def iterate(i: Int, minPrice: Int, maxProfit: Int): Int = {
      if (i >= prices.length) maxProfit
      else {
        if (prices(i) < minPrice) iterate(i+1, prices(i), maxProfit)
        else iterate(i+1, minPrice, maxProfit max (prices(i) - minPrice))
      }
    }
    iterate(0, Int.MaxValue, 0)
  }
}