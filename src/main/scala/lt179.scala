// https://leetcode.com/problems/largest-number/
object lt179 {
  def largestNumber(nums: Array[Int]): String = {
    val ans = nums.map(_.toString).sortWith((s1, s2) => s1 + s2 > s2 + s1).mkString("")
    ans.headOption match {
      case Some('0') => "0"
      case _ => ans
    }
  }
}
