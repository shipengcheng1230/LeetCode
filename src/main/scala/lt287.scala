// https://leetcode.com/problems/find-the-duplicate-number/
object lt287 {
  def findDuplicate(nums: Array[Int]): Int = {
    var slow = nums.head
    var fast = nums.head
    do {
      slow = nums(slow)
      fast = nums(nums(fast))
    } while (slow != fast)
    slow = nums.head
    while (slow != fast) {
      slow = nums(slow)
      fast = nums(fast)
    }
    fast
  }
}
