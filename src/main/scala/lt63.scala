// https://leetcode.com/problems/unique-paths-ii/
object lt63 {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    val m = obstacleGrid.length
    val n = obstacleGrid.head.length
    if (obstacleGrid(0)(0) == 1) 0
    else {
      obstacleGrid(0)(0) = 1
      for (i <- 1 until m) {
        obstacleGrid(i)(0) = if (obstacleGrid(i)(0) == 0 && obstacleGrid(i-1)(0) == 1) 1 else 0
      }
      for (i <- 1 until n) {
        obstacleGrid(0)(i) = if (obstacleGrid(0)(i) == 0 && obstacleGrid(0)(i - 1) == 1) 1 else 0
      }
      for (i <- 1 until m; j <- 1 until n) {
        if (obstacleGrid(i)(j) == 0) {
          obstacleGrid(i)(j) = obstacleGrid(i - 1)(j) + obstacleGrid(i)(j - 1)
        } else {
          obstacleGrid(i)(j) = 0
        }
      }
      obstacleGrid.last.last
    }
  }
}
