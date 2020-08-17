// https://leetcode.com/problems/first-missing-positive/
object lt41 {
  def firstMissingPositive(nums: Array[Int]): Int = {
    val a = 1
    val b = nums.length
    var i = 0
    while (i < b) {
      val num = nums(i)
      if (a <= num && num <= b && i != num - 1) {
        val replaced = nums(num - 1)
        if (a <= replaced && replaced <= b && replaced != num) {
          nums(num - 1) = num
          nums(i) = replaced
        } else {
          nums(num - 1) = num
          i += 1
        }
      } else i += 1
      println(nums.toList)
    }

    i = 0
    while (i < b) {
      if (nums(i) - i != 1) return i + 1
      i += 1
    }

    b + 1
  }

  def main(args: Array[String]): Unit = {
    firstMissingPositive(Array(3,4,-1,1))
  }
}
