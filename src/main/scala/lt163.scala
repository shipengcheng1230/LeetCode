// https://leetcode.com/problems/missing-ranges/
object lt163 {
  def findMissingRanges(nums: Array[Int], lower: Int, upper: Int): List[String] = {
    if (nums.isEmpty) {
      if (upper == lower) return List(s"${lower}")
      else return List(s"${lower}->${upper}")
    }

    import scala.collection.mutable.ListBuffer
    val ans = ListBuffer.empty[String]
    if (nums.head - lower == 1) ans.append(s"${lower}")
    else if (nums.head - lower > 1) ans.append(s"${lower}->${nums.head - 1}")
    for (i <- 1 until nums.length) {
      if (nums(i) - nums(i - 1) > 2) {
        ans.append(s"${nums(i - 1) + 1}->${nums(i) - 1}")
      } else if (nums(i) - nums(i - 1) == 2) {
        ans.append(s"${nums(i - 1) + 1}")
      }
    }
    if (upper - nums.last == 1) ans.append(s"${upper}")
    else if (upper - nums.last > 1) ans.append(s"${nums.last + 1}->${upper}")
    ans.toList
  }
}
