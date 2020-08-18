// https://leetcode.com/problems/permutations/
object lt46 {
  def permute(nums: Array[Int]): List[List[Int]] = {

    def helper(nums: Set[Int]): List[List[Int]] = {
      if (nums.isEmpty) List(List.empty[Int])
      else nums.flatMap(x => helper(nums.excl(x)).map(x :: _)).toList
    }

    helper(nums.toSet)
  }
}
