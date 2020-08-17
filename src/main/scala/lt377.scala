// https://leetcode.com/problems/combination-sum-iv/
object lt377 {
  def combinationSum4(nums: Array[Int], target: Int): Int = {
    val memo = scala.collection.mutable.Map.empty[Int, Int]

    def helper(nums: Array[Int], target: Int): Int = {
      if (target == 0) 1
      else if (target < 0) 0
      else if (memo.contains(target)) memo(target)
      else {
        val res = nums.map(x => helper(nums, target - x)).sum
        memo.update(target, res)
        res
      }
    }

    helper(nums.sorted(Ordering[Int].reverse), target)
  }

  def main(args: Array[String]): Unit = {
    println(combinationSum4(Array(1,2,3), 4))
  }
}
