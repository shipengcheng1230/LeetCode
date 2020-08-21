
// https://leetcode.com/problems/4sum/
object lt18 {
  import scala.collection.mutable.ListBuffer

  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
    kSum(nums.sorted, 0, 4, target).map(_.toList).toList
  }

  def kSum(nums: Array[Int], start: Int, k: Int, target: Int): ListBuffer[ListBuffer[Int]] = {
    val len = nums.length
    val res = ListBuffer.empty[ListBuffer[Int]]
    if (k == 2) {
      var left = start
      var right = nums.length - 1
      while (left < right) {
        val sum = nums(left) + nums(right)
        if (sum == target) {
          val path = ListBuffer(nums(left), nums(right))
          res.append(path)
          while (left < right && nums(left) == nums(left + 1)) left += 1
          while (left < right && nums(right) == nums(right - 1)) right -= 1
          left += 1
          right -= 1
        } else if (sum < target) left += 1
        else right -= 1
      }
    } else {
      (start until (len - (k - 1))).foreach(i => {
        if (i == start || nums(i) != nums(i - 1)) {
          val temp = kSum(nums, i + 1, k - 1, target - nums(i))
          temp.foreach(t => t.prepend(nums(i)))
          res.addAll(temp)
        }
      })
    }
    res
  }

  def main(args: Array[String]): Unit = {
    println(fourSum(Array(1,0,-1,0,-2,2), 0))
  }
}
