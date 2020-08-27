// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
object lt153 {
  def findMin(nums: Array[Int]): Int = {
    var lo = 0
    var hi = nums.length - 1
    while (lo < hi) {
      val mi = lo + (hi - lo) / 2
      if (nums(mi) < nums(hi)) hi = mi
      else lo = mi + 1
    }
    nums(lo)
  }
}
