// https://leetcode.com/problems/longest-increasing-subsequence/
object lt300 {
  def lengthOfLIS(nums: Array[Int]): Int = {
    import scala.annotation.tailrec

    @tailrec
    def lowerBound(v: Vector[Int], x: Int, lo: Int, hi: Int): Int = {
      if (lo + 1 == hi) hi
      else {
        val mi = (lo + hi) / 2
        if (v(mi) < x) lowerBound(v, x, mi, hi)
        else lowerBound(v, x, lo, mi)
      }
    }

    nums.foldLeft(Vector[Int](Int.MinValue))((v, x) => {
      if (x > v.last) v :+ x
      else v.updated(lowerBound(v, x, 0, v.length), x)
    }).length - 1
  }
}
