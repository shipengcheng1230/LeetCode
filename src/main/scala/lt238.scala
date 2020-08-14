// https://leetcode.com/problems/product-of-array-except-self/
object lt238 {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val x = nums.scanLeft(1)(_ * _).init
    val y = nums.scanRight(1)(_ * _).tail
    (x zip y).map(a => a._2 * a._1)
  }
}
