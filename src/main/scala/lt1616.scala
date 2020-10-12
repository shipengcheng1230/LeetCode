// https://leetcode.com/problems/split-two-strings-to-make-palindrome/submissions/
object lt1616 {
  def checkPalindromeFormation(a: String, b: String): Boolean = {

    def isPal(s: String): Boolean = {
      var l = 0
      var r = s.length - 1
      while (l < r) {
        if (s(l) != s(r)) return false
        l += 1
        r -= 1
      }
      true
    }

    def helper(a: String, b: String): Boolean = {
      val l = a.length
      val center = l % 2
      for (i <- 0 until l) {
        if (i * 2 + center >= l) return true
        if (a(i) != b(l - i - 1)) {
          if (isPal(b.substring(i, l - i)) || isPal(a.substring(i, l - i))) return true
          else return false
        }
      }
      true
    }

    helper(a, b) || helper(b, a)
  }
}
