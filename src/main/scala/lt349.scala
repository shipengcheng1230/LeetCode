// https://leetcode.com/problems/intersection-of-two-arrays/
object lt349 {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val l1 = nums1.sorted
    val l2 = nums2.sorted
    var l = 0
    var r = 0
    val ans = scala.collection.mutable.ArrayBuffer.empty[Int]
    while (l < l1.length && r < l2.length) {
      val left = l1(l)
      val right = l2(r)
      if (left == right) {
        ans.addOne(left)
        while (l < l1.length && left == l1(l)) l += 1
        while (r < l2.length && right == l2(r)) r += 1
      } else if (right > left) {
        while (l < l1.length && left == l1(l)) l += 1
      } else {
        while (r < l2.length && right == l2(r)) r += 1
      }
    }
    ans.toArray
  }
}
