// https://leetcode.com/problems/coin-path/
object lt656 {
  def cheapestJump(A: Array[Int], B: Int): List[Int] = {
    val next = Array.fill(A.length)(-1)
    val dp = Array.fill(A.length)(0)
    val ans = scala.collection.mutable.ListBuffer.empty[Int]
    for (i <- A.length - 2 to 0 by -1) {
      var minCost = Int.MaxValue
      for (j <- i + 1 to i + B; if j < A.length) {
        if (A(j) >= 0) {
          val cost = A(i) + dp(j)
          if (cost < minCost) {
            minCost = cost
            next(i) = j
          }
        }
      }
      dp(i) = minCost
    }
    var i = 0
    while (i < A.length && next(i) > 0) {
      ans.addOne(i + 1)
      i = next(i)
    }
    if (i == A.length - 1 && A(i) >= 0)
      ans.addOne(A.length).toList
    else
      Nil
  }

  def main(args: Array[String]): Unit = {
    println(cheapestJump(Array(0, 0, 0, 0, 0, 0), 3))
  }
}
