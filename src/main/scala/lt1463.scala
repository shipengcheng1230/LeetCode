// https://leetcode.com/problems/cherry-pickup-ii/
object lt1463 {
  def cherryPickup(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid.head.length
    val dp = Array.fill(m, n, n)(-1)

    def helper(i: Int, j: Int, k: Int): Int = {
      if (i == m) 0
      else if (dp(i)(j)(k) >= 0) dp(i)(j)(k)
      else {
        var ans = 0
        List(j-1, j, j+1).map(j2 => {
          List(k-1, k, k+1).map(k2 => {
            if (j2 >= 0 && j2 < n && k2 >= 0 && k2 < n) {
              ans = ans max helper(i+1, j2, k2)
            }
          })
        })
        dp(i)(j)(k) = ans + (if (j == k) grid(i)(j) else grid(i)(j) + grid(i)(k))
        dp(i)(j)(k)
      }
    }

    helper(0, 0, n - 1)
  }

  def main(args: Array[String]): Unit = {
    println(cherryPickup(Array(Array(3,1,1), Array(2,5,1), Array(1,5,5), Array(2,1,1))))
  }
}
