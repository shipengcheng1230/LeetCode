// https://leetcode.com/problems/single-number-ii/
object lt137 {
  def singleNumber(nums: Array[Int]): Int = {
    var once = 0
    var twice = 0
    nums.foreach(num => {
      once = ~twice & (once ^ num)
      twice = ~once & (twice ^ num)
    })
    once
  }
}
