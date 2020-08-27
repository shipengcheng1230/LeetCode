// https://leetcode.com/problems/island-perimeter/
object lt463 {
  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid.head.length
    var ans = 0
    for {
      i <- 0 until m
      j <- 0 until n
    } {
      if (grid(i)(j) == 1) {
        ans += 4
        if (i > 0 && grid(i - 1)(j) == 1) ans -= 2
        if (j > 0 && grid(i)(j - 1) == 1) ans -= 2
      }
    }
    ans
  }
}
