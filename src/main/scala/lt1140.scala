// https://leetcode.com/problems/stone-game-ii/
object lt1140 {
  def stoneGameII(piles: Array[Int]): Int = {
    val presum = piles.scanRight(0)(_ + _)
    val memo = Array.fill(piles.length, piles.length)(-1)

    def dfs(m: Int, p: Int): Int = {
      if (p + 2 * m >= piles.length) presum(p)
      else {
        if (memo(p)(m) > 0) memo(p)(m)
        else {
          var res = 0
          var take = 0
          (1 to 2 * m).foreach(i => {
            take = presum(p) - presum(p + i)
            // both play optimally
            res = Math.max(res, take + presum(p + i) - dfs(m max i, p + i))
          })
          memo(p)(m) = res
          res
        }
      }
    }

    dfs(1, 0)
  }

  def main(args: Array[String]): Unit = {
    println(stoneGameII(Array(2,7,9,4,4)))
  }
}
