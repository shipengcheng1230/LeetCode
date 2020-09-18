// https://leetcode.com/problems/one-edit-distance/
object lt161 {
  def isOneEditDistance(s: String, t: String): Boolean = {
    val ns = s.length
    val nt = t.length
    if (ns > nt) isOneEditDistance(t, s)
    else if (nt - ns > 1) false
    else {
      for (i <- 0 until ns) {
        if (s(i) != t(i)) {
          if (ns == nt) return s.substring(i + 1) == t.substring(i + 1)
          else return s.substring(i) == t.substring(i + 1)
        }
      }
      ns + 1 == nt
    }
  }
}
