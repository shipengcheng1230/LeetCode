// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
object lt1249 {
  def minRemoveToMakeValid(s: String): String = {
    val sb = new StringBuilder
    var open = 0
    var balance = 0

    s.indices.foreach(i => {
      val c = s(i)
      if (c == '(') {
        open += 1
        balance += 1
        sb.append(c)
      } else if (c == ')') {
        if (balance > 0) {
          balance -= 1
          sb.append(c)
        }
      } else sb.append(c)
    })

    val res = new StringBuilder
    var openToKeep = open - balance
    sb.indices.foreach(i => {
      val c = sb(i)
      if (c == '(') {
        openToKeep -= 1
        if (openToKeep >= 0) res.append(c)
      } else res.append(c)
    })
    res.toString()
  }
}
