// https://leetcode.com/problems/missing-element-in-sorted-array/
object lt1060 {
  def missing(nums: Array[Int], idx: Int): Int = nums(idx) - nums(0) - idx

  def missingElement(nums: Array[Int], k: Int): Int = {
    if (k > missing(nums, nums.length - 1)) nums.last + k - missing(nums, nums.length - 1)
    else {
      var left = 0
      var right = nums.length - 1
      while (left < right) {
        val pivot = (left + right) / 2
        if (missing(nums, pivot) < k) left = pivot + 1
        else right = pivot
      }
      nums(left-1) + k - missing(nums, left-1)
    }
  }
}
