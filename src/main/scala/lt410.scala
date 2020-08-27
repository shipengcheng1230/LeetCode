// https://leetcode.com/problems/split-array-largest-sum/
object lt410 {
  def splitArray(nums: Array[Int], m: Int): Int = {
    val n = nums.length
    val dp = Array.fill(n + 1, m + 1)(Int.MaxValue)
    dp(0)(0) = 0
    val presum = nums.scanLeft(0)(_ + _)
    for {
      i <- 1 to n
      j <- 1 to m
      k <- 0 until i
    } {
      dp(i)(j) = dp(i)(j) min (dp(k)(j - 1) max (presum(i) - presum(k)))
    }
    dp(n)(m)
  }

  def splitArray2(nums: Array[Int], m: Int): Int = {
    var (l, r) = nums.foldLeft((0.toLong, 0.toLong))((acc, x)  => (acc._1 max x, acc._2 + x))
    var ans = r
    while (l <= r) {
      val mid = l + (r - l) / 2
      var sum: Long = 0
      var cnt = 1
      nums.foreach(num => {
        if (sum + num > mid) {
          cnt += 1
          sum = num
        } else sum += num
      })
      if (cnt <= m) {
        ans = ans min mid
        r = mid - 1
      } else l = mid + 1
    }
    ans.toInt
  }

  def main(args: Array[String]): Unit = {
    println(splitArray2(Array(1,4,4), 3))
  }
}
