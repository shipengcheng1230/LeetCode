// https://leetcode.com/problems/evaluate-reverse-polish-notation/
object lt150 {
  def evalRPN(tokens: Array[String]): Int = {
    val stack = scala.collection.mutable.Stack.empty[Int]
    var ans = 0
    tokens.foreach(tk => {
      if ("+-*/".contains(tk)) {
        val n2 = stack.pop()
        val n1 = stack.pop()
        val n = tk match {
          case "+" => n1 + n2
          case "-" => n1 - n2
          case "*" => n1 * n2
          case "/" => n1 / n2
        }
        stack.push(n)
      } else stack.push(tk.toInt)
    })
    stack.pop()
  }
}
