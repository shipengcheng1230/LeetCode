// https://leetcode.com/problems/single-element-in-a-sorted-array/
object lt540 {
  def singleNonDuplicate(nums: Array[Int]): Int = {
    var lo = 0
    var hi = nums.length - 1
    while (lo < hi) {
      val mid = lo + (hi - lo) / 2
      val even = (hi - mid) % 2 == 0
      if (nums(mid + 1) == nums(mid)) {
        if (even) lo = mid + 2
        else hi = mid - 1
      } else if (nums(mid - 1) == nums(mid)) {
        if (even) hi = mid - 2
        else lo = mid + 1
      } else return nums(mid)
    }
    nums(lo)
  }
}
