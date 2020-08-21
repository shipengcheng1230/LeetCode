// https://leetcode.com/problems/longest-valid-parentheses/
object lt32 {
  def longestValidParentheses(s: String): Int = {
    var left = 0
    var right = 0
    var ans = 0
    s.indices.foreach(i => {
      val c = s(i)
      if (c == '(') left += 1
      if (c == ')') right += 1
      if (left == right) ans = ans max (2 * right)
      else if (right >left) {
        left = 0
        right = 0
      }
    })
    left = 0
    right = 0
    s.indices.reverse.foreach(i => {
      val c = s(i)
      if (c == '(') left += 1
      if (c == ')') right += 1
      if (left == right) ans = ans max (2 * left)
      else if (right < left) {
        left = 0
        right = 0
      }
    })
    ans
  }
}
