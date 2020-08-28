// https://leetcode.com/problems/remove-k-digits/
object lt402 {
  def removeKdigits(num: String, k: Int): String = {
    import scala.collection.mutable

    val stack = mutable.Stack.empty[Char]
    var count = k
    num.foreach(c => {
      while (stack.nonEmpty && count > 0 && stack.head > c) {
        stack.pop()
        count -= 1
      }
      stack.push(c)
    })
    (0 until count).foreach(_ => if (stack.nonEmpty) stack.pop())
    val ans = stack.reverse.mkString("").dropWhile(_ == '0')
    if (ans.isEmpty) "0" else ans
  }
}
