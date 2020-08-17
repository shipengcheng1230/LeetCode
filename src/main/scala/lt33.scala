// https://leetcode.com/problems/search-in-rotated-sorted-array/
object lt33 {
  def search(nums: Array[Int], target: Int): Int = {
    if (nums.isEmpty) return -1
    if (nums.length == 1) {
      if (nums.head == target) return 0 else return -1
    }
    val n = nums.length
    val rotateIndex = searchRotateIndex(nums, 0, n-1)
    if (nums(rotateIndex) == target) rotateIndex
    else if (rotateIndex == 0) binarySearch(nums, 0, n - 1, target)
    else if (target < nums.head) binarySearch(nums, rotateIndex, n - 1, target)
    else binarySearch(nums, 0, rotateIndex, target)
  }

  def binarySearch(nums: Array[Int], left: Int, right: Int, target: Int): Int = {
    var (l, r) = (left, right)
    while (l <= r) {
      val pivot = (l + r) / 2
      if (nums(pivot) == target) return pivot
      else if (nums(pivot) < target) l = pivot + 1
      else r = pivot - 1
    }
    -1
  }

  def searchRotateIndex(nums: Array[Int], left: Int, right: Int): Int = {
    if (nums(left) < nums(right)) 0 else {
      var (l, r) = (left, right)
      while (l <= r) {
        val pivot = (l + r) / 2
        if (nums(pivot) > nums(pivot + 1)) return pivot + 1
        else {
          if (nums(pivot) < nums(l)) r = pivot - 1
          else l = pivot + 1
        }
      }
      0
    }
  }

  def main(args: Array[String]): Unit = {
    println(search(Array(4,5,6,7,0,1,2), 0))
  }
}
