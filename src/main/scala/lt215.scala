// https://leetcode.com/problems/kth-largest-element-in-an-array/
object lt215 {
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    import scala.annotation.tailrec

    @tailrec
    def quickSelect(left: Int, right: Int): Int = {
      if (left > right) nums(left)
      else {
        var pivot = left
        (left + 1 to right).foreach(i => {
          if (nums(i) < nums(left)) {
            pivot += 1
            swap(i, pivot)
          }
        })
        swap(left, pivot)
        val count = nums.length - pivot
        if (count > k) quickSelect(pivot + 1, right)
        else if (count < k) quickSelect(left, pivot - 1)
        else nums(pivot)
      }
    }

    def swap(a: Int, b: Int): Unit = {
      val tmp = nums(a)
      nums(a) = nums(b)
      nums(b) = tmp
    }

    quickSelect(0, nums.length - 1)
  }

  def main(args: Array[String]): Unit = {
    println(findKthLargest(Array(3,2,3,1,2,4,5,5,6), 4))
  }
}
