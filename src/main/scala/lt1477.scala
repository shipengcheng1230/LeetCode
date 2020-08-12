// https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
object lt1477 {
  def minSumOfLengths(arr: Array[Int], target: Int): Int = {
    val n = arr.length
    val best = Array.fill(n)(Integer.MAX_VALUE)
    var sum = 0
    var start = 0
    var ans = Integer.MAX_VALUE
    var bestSoFar = Integer.MAX_VALUE

    (0 until n).foreach(i => {
      sum += arr(i)
      while (sum > target) {
        sum -= arr(start)
        start += 1
      }
      if (sum == target) {
        // implication: a[i] >= 1 ensure `best(start - 1)` stops before current `start`
        if (start > 0 && best(start - 1) != Integer.MAX_VALUE) {
          ans = ans min (best(start - 1) + i - start + 1)
        }
        bestSoFar = bestSoFar min (i - start + 1)
      }
      best(i) = bestSoFar
    })
    if (ans == Integer.MAX_VALUE) -1 else ans
  }

  def main(args: Array[String]): Unit = {
    print(minSumOfLengths(Array(1,1,1,1,1,1,2,3,3,2,1), 6))
  }
}
