// https://leetcode.com/problems/last-substring-in-lexicographical-order/
object lt1163 {
  def lastSubstring(s: String): String = {
    var i = 0
    var j = 1
    var offset = 0
    val n = s.length
    while (i + offset < n && j + offset < n) {
      val c = s(i + offset)
      val d = s(j + offset)
      if (c == d) offset += 1
      else {
        if (c < d) i += offset + 1
        else j += offset + 1
        if (i == j) j += 1
        offset = 0
      }
    }
    s.substring(i)
  }
}
