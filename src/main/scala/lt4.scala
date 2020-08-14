import scala.annotation.tailrec

// https://leetcode.com/problems/median-of-two-sorted-arrays/
object lt4 {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {

    @tailrec
    def getKth(a1: Array[Int], a2: Array[Int], k: Int): Double = {
      if (a1.isEmpty) a2(k - 1)
      else if (a2.isEmpty) a1(k - 1)
      else if (k == 1) a1.head min a2.head
      else {
        val p1 = math.min(k / 2, a1.length)
        val p2 = math.min(k / 2, a2.length)
        if (a1(p1 - 1) < a2(p2 - 1)) getKth(a1.splitAt(p1)._2, a2, k - p1)
        else getKth(a1, a2.splitAt(p2)._2, k - p2)
      }
    }
    val len = nums1.length + nums2.length
    (getKth(nums1, nums2, (len + 1) / 2) + getKth(nums1, nums2, (len + 2) / 2)) / 2.0
  }

  def main(args: Array[String]): Unit = {
    println(findMedianSortedArrays(Array(1,3), Array(2)))
  }
}
