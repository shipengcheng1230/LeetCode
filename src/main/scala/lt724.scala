// https://leetcode.com/problems/find-pivot-index/
object lt724 {
  def pivotIndex(nums: Array[Int]): Int = {
    val presum = nums.scanLeft(0)(_ + _)
    val total = presum.last
    for (i <- nums.indices) {
      if (presum(i) * 2 == total - nums(i)) return i
    }
    -1
  }
}
