object lt227 {
  import scala.collection.mutable

  def calculate(s: String): Int = {
    val stack = mutable.Stack.empty[Int]
    var num = 0
    var op = 0.toChar
    val operations = Set('*', '+', '/', '-')

    for (c <- s + '+') {
      if (c.isDigit) num = num * 10 + c.asDigit
      else if (operations contains c) {
        num = op match {
          case '/' => stack.pop() / num
          case '*' => stack.pop() * num
          case '-' => -num
          case _ => num
        }
        stack.push(num)
        num = 0
        op = c
      }
    }
    stack.popAll().sum
  }
}