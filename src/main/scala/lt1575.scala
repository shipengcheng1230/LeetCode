// https://leetcode.com/problems/count-all-possible-routes/
object lt1575 {
  def countRoutes(locations: Array[Int], start: Int, finish: Int, fuel: Int): Int = {

    val dp = Array.fill(locations.length, fuel + 1)(-1)
    val mod = 1_000_000_007
    val n = locations.length

    def helper(start: Int, remain: Int): Int = {
      if (remain < 0) 0
      else if (dp(start)(remain) > -1) dp(start)(remain)
      else {
        var res = if (start == finish) 1 else 0
        for (i <- 0 until n; if i != start)
          res = (res + helper(i, remain - math.abs(locations(start) - locations(i)))) % mod

        dp(start)(remain) = res
        dp(start)(remain)
      }
    }

    helper(start, fuel)
  }
}
