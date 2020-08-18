// https://leetcode.com/problems/move-zeroes/
object lt283 {
  def moveZeroes(nums: Array[Int]): Unit = {

    def swap(i: Int, j: Int): Unit = {
      val tmp = nums(i)
      nums(i) = nums(j)
      nums(j) = tmp
    }

    var (a, b) = (0, 0)
    while (b < nums.length) {
      if (nums(b) != 0) {
        swap(a, b)
        a += 1
        b += 1
      } else {
        b += 1
      }
    }
  }
}
