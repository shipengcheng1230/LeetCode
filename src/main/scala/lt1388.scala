// https://leetcode.com/problems/pizza-with-3n-slices/
object lt1388 {
  def maxSizeSlices(slices: Array[Int]): Int = {

    def maxSum(arr: Array[Int], n: Int): Int = {
      val m = arr.length
      val dp = Array.fill(m + 1, m + 1)(0)
      for (i <- 1 to m; j <- 1 to n) {
        if (i == 1) dp(i)(j) = arr(0)
        else dp(i)(j) = math.max(dp(i - 1)(j), dp(i - 2)(j - 1) + arr(i - 1))
      }
      dp(m)(n)
    }

    val m = slices.length
    val n = m / 3
    maxSum(slices.slice(0, m - 1), n) max maxSum(slices.slice(1, m), n)
  }
}
