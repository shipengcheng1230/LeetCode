// https://leetcode.com/problems/swap-adjacent-in-lr-string/
object lt777 {
  def canTransform(start: String, end: String): Boolean = {

    if (start.replace("X", "") != end.replace("X", "")) false
    else {
      var t = 0
      for (i <- start.indices) {
        if (start(i) == 'L') {
          while (end(t) != 'L') t += 1
          if (i < t) return false
          t += 1
        }
      }

      t = 0
      for (i <- start.indices) {
        if (start(i) == 'R') {
          while (end(t) != 'R') t += 1
          if (i > t) return false
          t += 1
        }
      }
      true
    }
  }
}
