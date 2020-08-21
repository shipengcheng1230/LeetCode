// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
object lt1283 {
  def smallestDivisor(nums: Array[Int], threshold: Int): Int = {
    import scala.annotation.tailrec

    nums.sortInPlace()

    @tailrec
    def binarySearch(left: Int, right: Int): Int = {
      if (left >= right) left
      else {
        val mid = left + (right - left) / 2
        val res = nums.foldLeft(0)((acc, x) => acc + (x / mid.toDouble).ceil.toInt)
        if (res > threshold)
          binarySearch(mid + 1, right)
        else
          binarySearch(left, mid)
      }
    }

    binarySearch(1, nums.last)
  }

  def main(args: Array[String]): Unit = {
    println(smallestDivisor(Array(1,2,5,9), 6))
  }
}
