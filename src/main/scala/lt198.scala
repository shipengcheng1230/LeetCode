// https://leetcode.com/problems/house-robber/
object lt198 {
  def rob(nums: Array[Int]): Int = {
    var pre = 0
    var cur = 0
    nums.foreach(num => {
      val tmp = cur
      cur = cur max (pre + num)
      pre = tmp
    })
    cur
  }
}
