// https://leetcode.com/problems/house-robber-ii/
object lt213 {
  def rob(nums: Array[Int]): Int = {
    if (nums.isEmpty) 0
    else if (nums.length == 1) nums.head
    else rob1(nums, 0, nums.length - 2) max rob1(nums, 1, nums.length - 1)
  }

  def rob1(nums: Array[Int], i: Int, e: Int): Int = {
    var cur = 0
    var pre = 0
    (i to e).foreach(i => {
      val num = nums(i)
      val tmp = cur
      cur = cur max (pre + num)
      pre = tmp
    })
    cur
  }
}
