// https://leetcode.com/problems/decode-ways/
object lt91 {
  def numDecodings(s: String): Int = {

    def helper(s: List[Char]): Int = {
      s match {
        case Nil => 1
        case x :: Nil => if (x == '0') 0 else 1
        case x :: y :: xs =>
          val consumeOne = if (x != '0') helper(y :: xs) else 0
          val consumeTwo = if (x == '1' || (x == '2' && y < '7')) helper(xs) else 0
          consumeOne + consumeTwo
      }
    }

    helper(s.toList)
  }

  def main(args: Array[String]): Unit = {
    println(numDecodings("123"))
  }
}
