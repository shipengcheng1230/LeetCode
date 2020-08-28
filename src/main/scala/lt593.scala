// https://leetcode.com/problems/valid-square/
object lt593 {
  def validSquare(p1: Array[Int], p2: Array[Int], p3: Array[Int], p4: Array[Int]): Boolean = {

    def distance(p1: Array[Int], p2: Array[Int]): Int =
      (p1(0) - p2(0)) * (p1(0) - p2(0)) + (p1(1) - p2(1)) * (p1(1) - p2(1))

    if (
      (p1 sameElements p2) ||
      (p1 sameElements p3) ||
      (p1 sameElements p4) ||
      (p2 sameElements p3) ||
      (p2 sameElements p4) ||
      (p3 sameElements p4))
      return false

    val s = Set(
      distance(p1, p2), distance(p1, p3), distance(p1, p4),
      distance(p2, p3), distance(p2, p4), distance(p3, p4))

    s.size == 2
  }
}
