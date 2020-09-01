// https://leetcode.com/problems/valid-parenthesis-string/
object lt678 {
  def checkValidString(s: String): Boolean = {
    var lo = 0
    var hi = 0
    s.foreach(c => {
      lo += (if (c == '(') 1 else -1)
      hi += (if (c != ')') 1 else -1)
      if (hi < 0) return lo == 0
      lo = lo max 0
    })
    lo == 0
  }
}
