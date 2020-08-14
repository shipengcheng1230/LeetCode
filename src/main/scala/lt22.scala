// https://leetcode.com/problems/generate-parentheses/
object lt22 {
  def generateParenthesis(n: Int): List[String] = {
    val ans = scala.collection.mutable.ListBuffer.empty[String]

    def helper(cur: String, open: Int, close: Int): Unit = {
      if (cur.length == 2 * n) ans.append(cur) else {
        if (open < n) helper(cur + '(', open + 1, close)
        if (open > close) helper(cur + ')', open,  close + 1)
      }
    }

    helper("", 0, 0)
    ans.toList
  }
}
