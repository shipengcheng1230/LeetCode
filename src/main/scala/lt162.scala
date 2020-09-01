// https://leetcode.com/problems/find-peak-element/
object lt162 {
  def findPeakElement(nums: Array[Int]): Int = {
    import scala.annotation.tailrec

    @tailrec
    def search(l: Int, r: Int): Int = {
      if (l == r) l
      else {
        val mid = l + (r - l) / 2
        if (nums(mid) > nums(mid + 1))
          search(l, mid)
        else
          search(mid + 1, r)
      }
    }

    search(0, nums.length - 1)
  }
}
