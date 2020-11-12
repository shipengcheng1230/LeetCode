// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
object lt1151 {
  def minSwaps(data: Array[Int]): Int = {
    val n = data.length
    val no = data.count(_ == 1)
    if (no <= 1) return 0
    var pre = data.slice(0, no).count(_ == 0)
    var leave = data(0)
    var ans = pre
    for (i <- 1 to n - no) {
      if (leave == 0) pre -= 1
      if (data(i + no - 1) == 0) pre += 1
      leave = data(i)
      ans = ans min pre
    }
    ans
  }
}
