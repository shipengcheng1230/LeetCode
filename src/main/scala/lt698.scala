// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
object lt698 {
  def canPartitionKSubsets(nums: Array[Int], k: Int): Boolean = {
    val sum = nums.sum
    val max = nums.max
    if (sum % k != 0 || max > sum / k) false
    else
      canPartitionKSubsets(nums, k, Array.fill(nums.length)(false), sum / k, 0, 0)
  }

  def canPartitionKSubsets(nums: Array[Int], k: Int, visited: Array[Boolean],
                           targetSubsetSum: Int, curSubsetSum: Int, nextIndexToCheck: Int): Boolean = {
    if (k == 0) return true

    if (curSubsetSum == targetSubsetSum)
      return canPartitionKSubsets(nums, k - 1, visited, targetSubsetSum, 0, 0)

    for { i <- nextIndexToCheck until nums.length } {
      if (!visited(i) && curSubsetSum + nums(i) <= targetSubsetSum) {
        visited(i) = true
        if (canPartitionKSubsets(nums, k, visited, targetSubsetSum, curSubsetSum + nums(i), i + 1))
          return true

        visited(i) = false
      }
    }

    false
  }
}
