// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
object lt1438 {
  def longestSubarray(nums: Array[Int], limit: Int): Int = {
    import scala.collection.mutable

    var (i, j) = (0, 0)
    val minq = mutable.ArrayDeque.empty[Int]
    val maxq = mutable.ArrayDeque.empty[Int]

    while (j < nums.length) {
      while (minq.nonEmpty && minq.last > nums(j)) minq.removeLast()
      while (maxq.nonEmpty && maxq.last < nums(j)) maxq.removeLast()
      minq.addOne(nums(j))
      maxq.addOne(nums(j))
      if (maxq.head - minq.head > limit) {
        if (maxq.head == nums(i)) maxq.removeHead()
        if (minq.head == nums(i)) minq.removeHead()
        i += 1
      }
      j += 1
    }
    j - i
  }
}
