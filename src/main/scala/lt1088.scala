// https://leetcode.com/problems/confusing-number-ii/
object lt1088 {
  def confusingNumberII(N: Int): Int = {
    val valid = Set(0, 1, 6, 8, 9)
    val map = Map(0 -> 0, 1 -> 1, 6 -> 9, 8 -> 8, 9 -> 6)
    var count = 0

    def dfs(n1: Long, n2: Long, base: Long): Unit = {
      if (n1 <= N) {
        if (n1 != n2) count += 1
        valid.foreach(i => {
          if (i != 0 || n1 != 0) dfs(n1 * 10 + i, base * map(i) + n2, base * 10)
        })
      }
    }

    dfs(1, 1, 10)
    dfs(6, 9, 10)
    dfs(8, 8, 10)
    dfs(9, 6, 10)
    count
  }
}
