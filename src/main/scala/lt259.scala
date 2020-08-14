// https://leetcode.com/problems/3sum-smaller/
object lt259 {
  def threeSumSmaller(nums: Array[Int], target: Int): Int = {
    val sa = nums.sorted
    sa.indices.foldLeft(0)((acc, i) => {
      acc + twoSumSmaller(sa, i, target)
    })
  }

  def twoSumSmaller(num: Array[Int], from: Int, target: Int): Int = {
    @scala.annotation.tailrec
    def helper(i: Int, j: Int, ans: Int): Int = {
      if (i < j) {
        if (num(i) + num(j) + num(from) < target) helper(i + 1, j, ans + j - i)
        else helper(i, j - 1, ans)
      } else ans
    }
    helper(from + 1, num.length - 1, 0)
  }
}
