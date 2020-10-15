// https://leetcode.com/problems/cracking-the-safe/
object lt753 {
  def crackSafe(n: Int, k: Int): String = {

    def dfs(curr: String, counted: Set[String], total: Int): String = {
      if (counted.size == total) curr
      else {
        for (i <- 0 until k) {
          val tmp = curr.takeRight(n - 1) + i.toString
          if (!counted.contains(tmp)) {
            val res = dfs(curr + i.toString, counted incl tmp, total)
            if (res.nonEmpty) return res
          }
        }
        ""
      }
    }

    dfs("0" * n, Set("0" * n), math.pow(k, n).toInt)
  }
}
