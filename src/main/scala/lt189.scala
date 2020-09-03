// https://leetcode.com/problems/rotate-array/
object lt189 {
  def rotate(nums: Array[Int], k: Int): Unit = {
    val kk = k % nums.length
    var count = 0
    var i = 0
    while (count < nums.length) {
      var current = i
      var prev = nums(i)
      do {
        val next = (current + kk) % nums.length
        val temp = nums(next)
        nums(next) = prev
        prev = temp
        current = next
        count += 1
      } while (i != current)
      i += 1
    }
  }
}
