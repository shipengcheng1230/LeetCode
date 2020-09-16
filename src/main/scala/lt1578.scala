// https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
object lt1578 {
  def minCost(s: String, cost: Array[Int]): Int = {
    var prev = '#'
    var sumCost = 0
    var maxCost = Int.MinValue
    var ans = 0
    s.zipWithIndex.foreach { case (c, i) =>
      if (c == prev || prev == '#') {
        sumCost += cost(i)
        maxCost = maxCost max cost(i)
      } else {
        ans += sumCost - maxCost
        sumCost = cost(i)
        maxCost = cost(i)
      }
      prev = c
    }
    ans + sumCost - maxCost
  }
}
