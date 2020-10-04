// https://leetcode.com/problems/paint-house/submissions/
object lt256 {
  def minCost(costs: Array[Array[Int]]): Int = {
    if (costs.isEmpty || costs.head.isEmpty) 0
    else {
      val n = costs.length
      val prev = costs.head.clone()
      for (i <- 1 until n) {
        val dp = Array.fill(3)(0)
        dp(0) = prev(1) min prev(2)
        dp(1) = prev(0) min prev(2)
        dp(2) = prev(0) min prev(1)
        prev.indices.foreach(j => prev(j) = costs(i)(j) + dp(j))
      }
      prev.min
    }
  }
}
