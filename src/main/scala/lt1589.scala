// https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/
object lt1589 {
  def maxSumRangeQuery(nums: Array[Int], requests: Array[Array[Int]]): Int = {
    val mod = (1e9 + 7).toInt
    // using Map cause TLE
    val freq = Array.fill(nums.length)(0)
    requests.foreach(r => (r(0) to r(1)).foreach(x => freq(x) += 1))
    (freq.sortWith(_ > _).zip(nums.sortWith(_ > _)).foldLeft(0L)((acc, x) => (acc + x._1.toLong * x._2)) % mod).toInt
  }
}
