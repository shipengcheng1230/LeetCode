// https://leetcode.com/problems/basic-calculator-iii/
object lt772 {
  def calculate(s: String): Int = {
    import scala.collection.mutable

    var sign = '+'
    val stack = mutable.Stack.empty[Int]
    var i = 0
    while (i < s.length) {
      val c = s(i)
      if (c == '(') {
        var l = 1
        var j = i + 1
        while (j < s.length && l > 0) {
          if (s(j) == '(') l += 1
          else if (s(j) == ')') l -= 1
          j += 1
        }
        val block = calculate(s.substring(i + 1, j - 1))
        i = j
        if (sign == '+')
          stack.push(block)
        else if (sign == '-')
          stack.push(-block)
        else if (sign == '*')
          stack.push(stack.pop() * block)
        else if (sign == '/')
          stack.push(stack.pop() / block)
      } else if (c.isDigit) {
        var j = i
        var value = 0
        while (j < s.length && s(j).isDigit) {
          value = value * 10 + s(j).asDigit
          j += 1
        }
        i = j
        if (sign == '+')
          stack.push(value)
        else if (sign == '-')
          stack.push(-value)
        else if (sign == '*')
          stack.push(stack.pop() * value)
        else if (sign == '/')
          stack.push(stack.pop() / value)
      } else if (c == '+' || c == '-' || c == '*' || c == '/') {
        sign = c
        i += 1
      } else i += 1
    }
    stack.sum
  }

  def main(args: Array[String]): Unit = {
    print(calculate("(2+6* 3+5- (3*14/7+2)*5)+3"))
  }
}
