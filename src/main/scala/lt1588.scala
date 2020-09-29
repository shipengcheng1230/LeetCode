// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
object lt1588 {
  def sumOddLengthSubarrays(arr: Array[Int]): Int = {
    var ans = 0
    for (i <- 0 until arr.length) {
      ans += ((arr.length - i) * (i + 1) + 1) / 2 * arr(i)
    }
    ans
  }
}
