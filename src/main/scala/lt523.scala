// https://leetcode.com/problems/continuous-subarray-sum/
object lt523 {
  def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
    import scala.collection.mutable
    val memo = mutable.Map.empty[Int, Int].addOne(0, -1)
    nums.indices.foldLeft(0)((acc, i) => {
      val s = if (k != 0) (acc + nums(i)) % k else acc + nums(i)
      if (memo.contains(s) && i - memo(s) >= 2)
        return true
      else {
        memo.getOrElseUpdate(s, i)
        s
      }
    })
    false
  }

  def main(args: Array[String]): Unit = {
    print(checkSubarraySum(Array(0, 0), 0))
  }
}
