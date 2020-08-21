// https://leetcode.com/problems/minimum-size-subarray-sum/
object lt209 {
  def minSubArrayLen(s: Int, nums: Array[Int]): Int = {
    var ans = Int.MaxValue
    var start = 0
    var sum = 0
    nums.indices.foreach(i => {
      sum += nums(i)
      while (sum >= s) {
        ans = ans min (i - start + 1)
        sum -= nums(start)
        start += 1
      }
    })
    if (ans == Int.MaxValue) 0 else ans
  }

  def main(args: Array[String]): Unit = {
    println(minSubArrayLen(7, Array(2,3,1,2,4,3)))
  }
}
