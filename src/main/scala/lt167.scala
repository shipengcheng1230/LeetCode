// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
object lt167 {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    @scala.annotation.tailrec
    def helper(l: Int, r: Int): Array[Int] = {
      if (l < r) {
        val sum = numbers(l) + numbers(r)
        if (sum == target) Array(l+1, r+1)
        else if (sum > target) helper(l, r - 1)
        else helper(l + 1, r)
      } else Array(-1, -1)
    }
    helper(0, numbers.length - 1)
  }
}
