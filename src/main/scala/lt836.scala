// https://leetcode.com/problems/rectangle-overlap/
object lt836 {
  def isRectangleOverlap(rec1: Array[Int], rec2: Array[Int]): Boolean = {
    if (rec1(0) >= rec2(2) || rec2(0) >= rec1(2))
      return false
    if (rec1(1) >= rec2(3) || rec2(1) >= rec1(3))
      return false
    true
  }
}
