// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
object lt34 {
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {

    def binarySearch(left: Boolean): Int = {
      var lo = 0
      var hi = nums.length

      while (lo < hi) {
        val mid = lo + (hi - lo) / 2
        if (nums(mid) > target || left && target == nums(mid))
          hi = mid
        else
          lo = mid + 1
      }
      lo
    }

    val left = binarySearch(true)
    if (left == nums.length || nums(left) != target) Array(-1, -1)
    else {
      val right = binarySearch(false)
      Array(left, right - 1)
    }
  }
}
