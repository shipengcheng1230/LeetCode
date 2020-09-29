// https://leetcode.com/problems/long-pressed-name/submissions/
object lt925 {
  def isLongPressedName(name: String, typed: String): Boolean = {
    var i = 0
    var j = 0
    var prev = '#'
    while (i < name.length || j < typed.length) {
      if (i == name.length) {
        if (typed(j) != prev) return false
        else j += 1
      }
      else if (j == typed.length) return false
      else {
        if (name(i) == typed(j)) {
          i += 1
          j += 1
          prev = typed(j - 1)
        } else {
          if (prev == typed(j)) j += 1
          else return false
        }
      }
    }

    true
  }
}
