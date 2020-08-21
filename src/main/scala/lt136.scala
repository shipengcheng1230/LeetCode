// https://leetcode.com/problems/single-number/
object lt136 {
  def singleNumber(nums: Array[Int]): Int = {
    nums.reduce(_ ^ _)
  }
}
