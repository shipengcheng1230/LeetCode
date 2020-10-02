// https://leetcode.com/problems/student-attendance-record-i/
object lt551 {
  def checkRecord(s: String): Boolean = {
    var i = 0
    var ca = 0
    var cl = 0
    while (i < s.length) {
      if (s(i) == 'A') ca += 1
      if (ca > 1) return false
      if (s(i) == 'L') {
        var j = i
        while (j < s.length && s(j) == 'L') j += 1
        if (j - i > 2) return false
        i = j max (i + 1)
      } else i += 1
    }
    true
  }
}
