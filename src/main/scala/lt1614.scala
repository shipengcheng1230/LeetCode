// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
object lt1614 {
  def maxDepth(s: String): Int = {
    var count = 0
    var ans = 0

    s.foreach(c => {
      if (c == '(') {
        count += 1
        ans = ans max count
      } else if (c == ')') {
        count -= 1
      }
    })
    ans
  }
}
