// https://leetcode.com/problems/jump-game-ii/
object lt45 {
  def jump(nums: Array[Int]): Int = {
    val n = nums.length
    if (n < 2) return 0

    var maxPos = nums(0)
    var maxStep = nums(0)
    var jump = 1
    for (i <- 1 until n) {
      if (maxStep < i) {
        jump += 1
        maxStep = maxPos
      }
      maxPos = maxPos max (nums(i) + i)
    }
    jump
  }

  def main(args: Array[String]): Unit = {
    print(jump(Array(2,3,1,1,4)))
  }
}
