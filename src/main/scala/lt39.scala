// https://leetcode.com/problems/combination-sum/
object lt39 {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {

    def helper(nums: List[Int], left: Int, acc: List[Int]): List[List[Int]] = {
      if (left < 0) Nil
      else if (left == 0) List(acc)
      else nums match {
        case Nil => Nil
        case x =>
          helper(x, left - x.head, x.head :: acc) :::
          helper(x.tail, left, acc)
      }
    }

    helper(candidates.toList, target, Nil)
  }
}
