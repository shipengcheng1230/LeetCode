
// https://leetcode.com/problems/basic-calculator/
object lt224 {
  def calculate(s: String): Int = {
    import scala.annotation.tailrec

    val stack = scala.collection.mutable.Stack.empty[Int]

    @tailrec
    def helper(cs: List[Char], value: Int, sign: Int, ans: Int): Int = cs match {
      case Nil => ans + value * sign
      case c :: rs => c match {
        case x if x.isDigit =>
          helper(rs, value * 10 + x.asDigit, sign, ans)
        case x if x == '+' =>
          helper(rs, 0, 1, ans + value * sign)
        case x if x == '-' =>
          helper(rs, 0, -1, ans + value * sign)
        case x if x == '(' =>
          stack.push(ans)
          stack.push(sign)
          helper(rs, 0, 1, 0)
        case x if x == ')' =>
          val res = value * sign + ans
          val prev = stack.pop() * res
          helper(rs, 0, 1, prev + stack.pop())
        case _ => helper(rs, value, sign, ans)
      }
    }

    helper(s.toList, 0, 1, 0)
  }

  def main(args: Array[String]): Unit = {
    println(calculate("1 - (2-(3+4-(5-6-7-(8-9))))"))
  }
}
