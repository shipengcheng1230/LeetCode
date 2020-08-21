// https://leetcode.com/problems/palindromic-substrings/
object lt647 {
  def countSubstrings(s: String): Int = {
    import scala.annotation.tailrec

    var total = 0

    @tailrec
    def extend(left: Int, right: Int, count: Int): Unit = {
      if (left >= 0 && right < s.length && s(left) == s(right))
        extend(left - 1, right + 1, count + 1)
      else total += count
    }

    if (s.isEmpty) 0
    else {
      s.indices.foreach(i => {
        extend(i, i, 0)
        extend(i, i + 1, 0)
      })
    }

    total
  }
}
