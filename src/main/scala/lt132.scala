// https://leetcode.com/problems/palindrome-partitioning-ii/
object lt132 {
  def minCut(s: String): Int = {
    val n = s.length
    val cut = (0 until n).toArray

    def search(left: Int, right: Int): Unit = {
      var l = left
      var r = right
      while (l >= 0 && r < s.length && s(l) == s(r)) {
        if (l == 0)
          cut(r) = 0
        else
          cut(r) = cut(r) min (cut(l - 1) + 1)
        l -= 1
        r += 1
      }
    }

    for (i <- 0 until s.length) {
      search(i, i)
      search(i, i + 1)
    }
    cut.last
  }
}
