// https://leetcode.com/problems/subarray-sum-equals-k/
object lt560 {
  def subarraySum(nums: Array[Int], k: Int): Int = {
    var count = 0
    var sum = 0
    val map = scala.collection.mutable.Map.empty[Int, Int]
    map.update(0, 1)
    nums.foreach(num => {
      sum += num
      if (map.contains(sum - k)) count += map(sum - k)
      map.update(sum, map.getOrElse(sum, 0) + 1)
    })
    count
  }
}
