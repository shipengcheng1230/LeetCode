// https://leetcode.com/problems/combination-sum-ii/
object lt40 {
  def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {

    def helper(nums: List[Int], left: Int, ans: List[Int]): List[List[Int]] = {
      if (left < 0) Nil
      else if (left == 0) List(ans)
      else nums match {
        case Nil => Nil
        case x =>
          helper(nums.tail, left - x.head, x.head :: ans) :::
          helper(nums.tail, left, ans)
      }
    }

    helper(candidates.sorted.toList, target, Nil).distinct
  }
}
