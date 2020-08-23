// https://leetcode.com/problems/longest-consecutive-sequence/
object lt128 {
  def longestConsecutive(nums: Array[Int]): Int = {
    val s = nums.toSet
    var ans = 0

    nums.foreach(num => {
      if (!s.contains(num - 1)) {
        var cur = num
        var l = 1
        while (s.contains(cur + 1)) {
          cur += 1
          l += 1
        }
        ans = ans max l
      }
    })

    ans
  }
}
