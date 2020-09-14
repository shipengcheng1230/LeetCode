// https://leetcode.com/problems/get-the-maximum-score/
object lt1537 {
  def maxSum(nums1: Array[Int], nums2: Array[Int]): Int = {
    var i = 0
    var j = 0
    val m = nums1.length
    val n = nums2.length
    var a = 0L
    var b = 0L
    val mod = (1e9 + 7).toInt

    while (i < m || j < n) {
      if (i < m && (j == n || nums1(i) < nums2(j))) {
        a += nums1(i)
        i += 1
      } else if (j < n && (i == m || nums1(i) > nums2(j))) {
        b += nums2(j)
        j += 1
      } else {
        a = (a max b) + nums1(i)
        b = a
        i += 1
        j += 1
      }
    }
    ((a max b) % mod).toInt
  }
}
