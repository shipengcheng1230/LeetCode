// https://leetcode.com/problems/student-attendance-record-ii/submissions/
object lt552 {
  def checkRecord(n: Int): Int = {
    val M = 1000000007
    val dp = Array.fill(if (n <= 5) 6 else n + 1)(0L)
    dp(0) = 1
    dp(1) = 2
    dp(2) = 4
    dp(3) = 7

    for (i <- 4 to n) {
      dp(i) = (2 * dp(i - 1)) % M + (M - dp(i - 4)) % M
    }
    var sum = dp(n)
    for (i <- 1 to n) sum += (dp(i - 1) * dp(n - i)) % M
    (sum % M).toInt
  }
}
