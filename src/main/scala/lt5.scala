import scala.annotation.tailrec

object lt5 {
  def longestPalindrome(s: String): String = {

    @tailrec
    def expand(left: Int, right: Int): Int = {
      if (left < 0 || right >= s.length || s(left) != s(right)) right - left - 1
      else expand(left-1, right+1)
    }

    if (s.isEmpty) ""
    else {
      var start = 0
      var end = 0
      for (i <- 0 until s.length) {
        val len1 = expand(i, i)
        val len2 = expand(i, i+1)
        val len = len1 max len2
        if (len > end - start) {
          start = i - (len - 1) / 2
          end = i + len / 2
        }
      }
      return s.substring(start, end + 1)
    }

  }
}
