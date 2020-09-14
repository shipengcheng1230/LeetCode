// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
object lt1547 {
  // same as lt312
  def minCost(n: Int, cuts: Array[Int]): Int = {
    import scala.collection.mutable

    val A = mutable.ArrayBuffer.empty[Int]
    A.addAll(cuts)
    A.addOne(0)
    A.addOne(n)
    A.sortInPlace()
    val k = A.length
    val dp = Array.fill(k, k)(0)
    for (d <- 2 until k; i <- 0 until k - d) {
      dp(i)(i + d) = Int.MaxValue
      for (m <- i + 1 until i + d) {
        dp(i)(i + d) = dp(i)(i + d) min (dp(i)(m) + dp(m)(i + d) + A(i + d) - A(i))
      }
    }
    dp(0)(k - 1)
  }
}
