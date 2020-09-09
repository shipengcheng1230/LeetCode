// https://leetcode.com/problems/create-maximum-number/
object lt321 {
  def maxNumber(nums1: Array[Int], nums2: Array[Int], k: Int): Array[Int] = {

    def maxArray(nums: Array[Int], l: Int): Array[Int] = {
      val stack = scala.collection.mutable.Stack.empty[Int]
      nums.indices.foreach(i => {
        while (stack.nonEmpty && stack.head < nums(i) && stack.size + nums.length - i > l)
          stack.pop()

        if (stack.size < l) stack.push(nums(i))
      })
      stack.toArray
    }

    def greater(nums1: Array[Int], nums2: Array[Int], i: Int, j: Int): Boolean = {
      var ii = i
      var jj = j
      while (ii < nums1.length && jj < nums2.length && nums1(ii) == nums2(jj)) {
        ii += 1
        jj += 1
      }
      jj == nums2.length || (ii < nums1.length && nums1(ii) > nums2(jj))
    }

    def merge(nums1: Array[Int], nums2: Array[Int], k: Int): Array[Int] = {
      val ans = Array.ofDim[Int](k)
      var i = 0
      var j = 0
      (0 until k).foreach(r => {
        if (greater(nums1, nums2, i, j)) {
          ans(r) = nums1(i)
          i += 1
        } else {
          ans(r) = nums2(j)
          j += 1
        }
      })
      ans
    }

    val n = nums1.length
    val m = nums2.length
    var ans = Array.ofDim[Int](k)
    for (i <- math.max(0, k - m) to math.min(k, n)) {
      val candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k)
      if (greater(candidate, ans, 0, 0)) ans = candidate
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    println(maxNumber(Array(3, 4, 6, 5), Array(9, 1, 2, 5, 8, 3), 5).mkString("Array(", ", ", ")"))
  }
}
