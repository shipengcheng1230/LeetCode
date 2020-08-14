// https://leetcode.com/problems/valid-parentheses/
object lt20 {
  def isValid(s: String): Boolean = {
    val stack = scala.collection.mutable.Stack.empty[Char]
    val matched = Map(')' -> '(', ']' -> '[', '}' -> '{')
    s.foreach(c => {
      if (c == '(' || c == '[' || c == '{') stack.push(c)
      else if (c == ')' || c == ']' || c == '}') {
        if (stack.isEmpty || stack.pop() != matched(c)) return false
      }
    })
    if (stack.isEmpty) true else false
  }
}
