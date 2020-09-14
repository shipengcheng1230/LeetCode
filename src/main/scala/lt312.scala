// https://leetcode.com/problems/burst-balloons/
object lt312 {
  // same as lt1547
  def maxCoins(nums: Array[Int]): Int = {
    val _nums = Array.fill(nums.length + 2)(0)
    val n = _nums.length

    nums.indices.foreach(i => _nums(i + 1) = nums(i))
    _nums(0) = 1
    _nums(n - 1) = 1

    val dp = Array.fill(n, n)(0)
    (2 until n).foreach(k => {
      (0 until n - k).foreach(left => {
        val right = left + k
        (left + 1 until right).foreach(i => {
          dp(left)(right) = dp(left)(right) max
            (_nums(left) * _nums(i) * _nums(right) + dp(left)(i) + dp(i)(right))
        })
      })
    })
    dp(0)(n - 1)
  }

  def main(args: Array[String]): Unit = {
    println(maxCoins(Array(3,1,5,8)))
  }
}
