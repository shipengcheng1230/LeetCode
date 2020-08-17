// https://leetcode.com/problems/merge-sorted-array/
object lt88 {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    var i = m - 1
    var j = n - 1
    var x = m + n - 1
    while (i >= 0 && j >= 0) {
      if (nums1(i) > nums2(j)) {
        nums1(x) = nums1(i)
        i -= 1
      } else {
        nums1(x) = nums2(j)
        j -= 1
      }
      x -= 1
    }
    while (j >= 0) {
      nums1(j) = nums2(j)
      j -= 1
    }
  }
}
