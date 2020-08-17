// https://leetcode.com/problems/combination-sum-iii/
object lt216 {
  def combinationSum3(k: Int, n: Int): List[List[Int]] = {

    def helper(nums: List[Int], left: Int, used: Int, ans: List[Int]): List[List[Int]] = {
      if (used > k) Nil
      else {
        if (left < 0) Nil
        else if (left == 0) {
          if (used == k) List(ans)
          else Nil
        }
        else nums match {
          case Nil => Nil
          case x =>
            helper(nums.tail, left - x.head, used + 1, x.head :: ans) :::
              helper(nums.tail, left, used, ans)
        }
      }
    }

    helper((1 to 9).toList, n, 0, Nil)
  }

  def main(args: Array[String]): Unit = {
    combinationSum3(3, 7).foreach(println)
  }
}
