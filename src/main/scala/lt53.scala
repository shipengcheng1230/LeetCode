// https://leetcode.com/problems/maximum-subarray/
object lt53 {
  def maxSubArray(nums: Array[Int]): Int = {
    val n = nums.length
    var cur = nums.head
    var ans = nums.head
    (1 until n).foreach(i => {
      // should we include it or start from it
      cur = nums(i) max (cur + nums(i))
      ans = ans max cur
    })
    ans
  }
}
