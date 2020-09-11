// https://leetcode.com/problems/partition-equal-subset-sum/
object lt416 {
  def canPartition(nums: Array[Int]): Boolean = {
    val total = nums.sum
    if (total % 2 != 0) false
    else {
      val subSetSum = total / 2
      val n = nums.length
      // if sum (j) can be formed from nums[0: i]
      val dp = Array.fill(n + 1, subSetSum + 1)(false)
      dp(0)(0) = true
      for (i <- 1 to n; j <- 0 to subSetSum) {
        val curr = nums(i - 1)
        if (j < curr) dp(i)(j) = dp(i - 1)(j)
        else dp(i)(j) = dp(i - 1)(j) || dp(i - 1)(j - curr)
      }
      dp(n)(subSetSum)
    }
  }
}
