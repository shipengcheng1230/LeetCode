// https://leetcode.com/problems/bomb-enemy/
object lt361 {
  def maxKilledEnemies(grid: Array[Array[Char]]): Int = {
    if (grid.isEmpty || grid.head.isEmpty) return 0

    val m = grid.length
    val n = grid.head.length
    var ans = 0
    var rowHits = 0
    val colHits = Array.fill(n)(0)
    for (i <- 0 until m; j <- 0 until n) {
      if (j == 0 || grid(i)(j - 1) == 'W') {
        rowHits = 0
        var k = j
        while (k < n && grid(i)(k) != 'W') {
          if (grid(i)(k) == 'E')
            rowHits += 1
          k += 1
        }
      }
      if (i == 0 || grid(i - 1)(j) == 'W') {
        colHits(j) = 0
        var k = i
        while (k < m && grid(k)(j) != 'W') {
          if (grid(k)(j) == 'E')
            colHits(j) += 1
          k += 1
        }
      }
      if (grid(i)(j) == '0')
        ans = ans max (rowHits + colHits(j))
    }
    ans
  }
}
