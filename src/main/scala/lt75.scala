// https://leetcode.com/problems/sort-colors/
object lt75 {
  def sortColors(nums: Array[Int]): Unit = {
    var p0 = 0
    var curr = 0
    var p2 = nums.length - 1

    while (curr <= p2) {
      if (nums(curr) == 0) {
        val tmp = nums(p0)
        nums(p0) = nums(curr)
        nums(curr) = tmp
        p0 += 1
        curr += 1
      } else if (nums(curr) == 2) {
        val tmp = nums(curr)
        nums(curr) = nums(p2)
        nums(p2) = tmp
        p2 -= 1
      } else
        curr += 1
    }
  }
}
