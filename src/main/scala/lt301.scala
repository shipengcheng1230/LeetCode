// https://leetcode.com/problems/remove-invalid-parentheses/
object lt301 {
  def removeInvalidParentheses(s: String): List[String] = {
    val (misLeft, misRight) = s.foldLeft((0, 0))((acc, x) => {
      if (x == '(') (acc._1 + 1, acc._2)
      else if (x == ')') {
        if (acc._1 > 0) (acc._1 - 1, acc._2)
        else (acc._1, acc._2 + 1)
      }
      else acc
    })

    val ans = scala.collection.mutable.ListBuffer.empty[String]

    def dfs(i: Int, input: String, l0: Int, r0: Int, l: Int, r: Int): Unit = {
      if (i == s.length) {
        if (l0 == 0 && r0 == 0) ans.append(input)
      } else {
        s(i) match {
          case c @ '(' =>
            if (l > 0) dfs(i + 1, input, l0, r0, l - 1, r)
            dfs(i + 1, input + c, l0 + 1, r0, l, r)
          case c @ ')' =>
            if (r > 0) dfs(i + 1, input, l0, r0, l, r - 1)
            val nl = if (l0 > 0) l0 - 1 else l0
            val nr = if (l0 > 0) r0 else r0 + 1
            dfs(i + 1, input + c, nl, nr, l, r)
          case c @ _ =>
            dfs(i + 1, input + c, l0, r0, l, r)
        }
      }
    }

    dfs(0, "", 0, 0, misLeft, misRight)
    ans.distinct.toList
  }

  def main(args: Array[String]): Unit = {
    print(removeInvalidParentheses("((a("))
  }
}
