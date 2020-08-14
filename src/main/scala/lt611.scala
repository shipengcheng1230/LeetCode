// https://leetcode.com/problems/valid-triangle-number/
object lt611 {
  def triangleNumber(nums: Array[Int]): Int = {
    val sa = nums.sorted
    sa.indices.foldLeft(0)((acc, i) => {
      acc + two(sa, i)
    })
  }

  def two(nums: Array[Int], from: Int): Int = {
    if (nums.length - from < 3) 0 else {
      var (lo, hi) = (from + 1, from + 2)
      var s = 0
      while (lo < nums.length - 1) {
        if (nums(from) + nums(lo) > nums(hi)) {
          s += hi - lo
          hi += 1
          if (hi == nums.length) return s
        } else {
          lo += 1
          if (lo == hi) hi += 1
        }
      }
      s
    }
  }
}
