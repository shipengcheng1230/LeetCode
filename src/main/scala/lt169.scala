// https://leetcode.com/problems/majority-element/
object lt169 {
  def majorityElement(nums: Array[Int]): Int = {
    var count = 0
    var candidate: Int = nums.head
    nums.foreach(num => {
      if (count == 0) candidate = num
      count += (if (num == candidate) 1 else -1)
    })
    candidate
  }
}
