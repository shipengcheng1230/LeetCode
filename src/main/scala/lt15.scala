// https://leetcode.com/problems/3sum/
object lt15 {
/*
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    import scala.collection.mutable

    val count = nums.groupMapReduce(identity)(_ => 1)(_ + _).to(mutable.Map)
    val ans = mutable.Set.empty[List[Int]]

    nums.indices.foreach(i => {
      val a = nums(i)
      count.update(a, count(a) - 1)

      (0 until i).foreach(j => {
        val b = nums(j)
        count.update(b, count(b) - 1)
        val c = -a - b
        if (count.contains(c) && count(c) > 0) ans.add(List(a, b, c).sorted)
        count.update(b, count(b) + 1)
      })

      count.update(a, count(a) + 1)
    })

    ans.toList
  }
*/

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    if (nums.isEmpty) List.empty[List[Int]] else {
      val numsS = nums.sorted
      numsS.indices.foldLeft(List.empty[List[Int]])((acc, i) => {
        if (numsS(i) <= 0 && (i == 0 || numsS(i-1) != numsS(i))) {
          twoSum(numsS, i) ::: acc
        } else acc
      })
    }
  }

  def twoSum(nums: Array[Int], from: Int): List[List[Int]] = {
    @scala.annotation.tailrec
    def helper(l: Int, r: Int, ans: List[List[Int]]): List[List[Int]] = {
      if (l < r) {
        val sum = nums(l) + nums(r) + nums(from)
        if (sum > 0 || (r < nums.length - 1 && nums(r) == nums(r + 1))) helper(l, r - 1, ans)
        else if (sum < 0 || (l > from + 1 && nums(l) == nums(l - 1))) helper(l + 1, r, ans)
        else helper(l + 1, r - 1, List(nums(from), nums(l), nums(r)) :: ans)
      } else ans
    }
    helper(from + 1, nums.length - 1, List.empty[List[Int]])
  }

  def main(args: Array[String]): Unit = {
//    println(twoSum(Array(-1, 0, 1, 2, -1, -4).sorted, 0))
    println(threeSum(Array(0,-4,-1,-4,-2,-3,2)))
  }
}
