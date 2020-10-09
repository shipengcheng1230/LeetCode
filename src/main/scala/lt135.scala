// https://leetcode.com/problems/candy/
object lt135 {
  def candy(ratings: Array[Int]): Int = {
    val n = ratings.length
    val record = Array.fill(n)(1)
    for (i <- 1 until n) {
      if (ratings(i) > ratings(i - 1)) {
        record(i) = record(i - 1) + 1
      } else {
        record(i) = 1
      }
    }
    for (i <- n - 1 to 1 by -1) {
      if (ratings(i) < ratings(i - 1) && record(i) >= record(i - 1)) {
        record(i - 1) = record(i) + 1
      }
    }
    record.sum
  }
}
