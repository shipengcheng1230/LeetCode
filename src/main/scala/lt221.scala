object lt221 {
  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    if (matrix.isEmpty || matrix.head.isEmpty) return 0

    val m = matrix.length
    val n = matrix.head.length
    val dp = Array.fill(m+1, n+1)(0)
    var ans = 0
    for {
      i <- 1 to m
      j <- 1 to n
    } {
      if (matrix(i-1)(j-1) == '1') {
        dp(i)(j) = dp(i-1)(j-1).min(dp(i)(j-1)).min(dp(i-1)(j)) + 1
        ans = ans max dp(i)(j)
      }
    }
    ans * ans
  }
}
