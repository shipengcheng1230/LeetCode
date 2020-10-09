// https://leetcode.com/problems/k-diff-pairs-in-an-array/
object lt532 {
  def findPairs(nums: Array[Int], k: Int): Int = {
    val count = nums.groupMapReduce(identity)(_ => 1)(_ + _)
    count.keys.foldLeft(Set.empty[(Int, Int)])((acc, x) => {
      if ((k != 0 && count.contains(x + k)) || (k == 0 && count(x) > 1))
        acc.incl((x, x + k))
      else
        acc
    }).size
  }
}
