// https://leetcode.com/problems/edit-distance/
object lt72 {
  def minDistance(word1: String, word2: String): Int = {
    val n = word1.length
    val m = word2.length
    if (n * m == 0) m + n
    else {
      val d = Array.fill(n + 1, m + 1)(0)
      (0 to n).foreach(i => d(i)(0) = i)
      (0 to m).foreach(i => d(0)(i) = i)
      for { i <- 1 to n; j <- 1 to m } {
        val left = d(i-1)(j) + 1
        val right = d(i)(j-1) + 1
        val diag = d(i-1)(j-1) + (if (word1(i-1) == word2(j-1)) 0 else 1)
        d(i)(j) = left min right min diag
      }
      d(n)(m)
    }
  }
}
