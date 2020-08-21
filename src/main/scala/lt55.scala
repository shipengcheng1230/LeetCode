// https://leetcode.com/problems/jump-game/
object lt55 {
  def canJump(nums: Array[Int]): Boolean = {
    var farthest = 0
    nums.indices.foreach(i => {
      if (i > farthest) return false
      farthest = farthest max (i + nums(i))
    })
    true
  }
}
