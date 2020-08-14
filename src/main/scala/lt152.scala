// https://leetcode.com/problems/maximum-product-subarray/
object lt152 {
  def maxProduct(nums: Array[Int]): Int = {
    var minprod = nums.head
    var maxprod = nums.head
    var ans = nums.head
    (1 until nums.length).foreach(i => {
      if (nums(i) == 0) {
        minprod = 0; maxprod = 0
      } else {
        val x = minprod * nums(i)
        val y = maxprod * nums(i)
        minprod = (x min y) min nums(i)
        maxprod = (x max y) max nums(i)
      }
      ans = ans max maxprod
    })
    ans
  }
}
