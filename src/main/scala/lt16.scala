// https://leetcode.com/problems/3sum-closest/
object lt16 {
  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    var diff = Integer.MAX_VALUE
    val n = nums.length
    val numsS = nums.sorted
    numsS.indices.foreach(i => {
      if (diff != 0) {
        var lo = i + 1
        var hi = n - 1
        while (lo < hi) {
          val sum = numsS(i) + numsS(lo) + numsS(hi)
          if (math.abs(target - sum) < math.abs(diff)) diff = target - sum
          if (sum < target) lo += 1
          else hi -= 1
        }
      } else return target
    })
    target - diff
  }

  def main(args: Array[String]): Unit = {
    println(threeSumClosest(Array(1,1,-1,-1,3), -1))
    println(threeSumClosest(Array(-1,2,1,-4), 1))
    println(threeSumClosest(Array(1,2,4,8,16,32,64,128), 82))
  }
}

