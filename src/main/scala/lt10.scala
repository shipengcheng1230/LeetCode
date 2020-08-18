// https://leetcode.com/problems/regular-expression-matching/
object lt10 {
  def isMatch(s: String, p: String): Boolean = {
    if (p.isEmpty) s.isEmpty else {
      val firstMatch = s.headOption.exists(_ == p.head || p.head == '.')
      p.tail.headOption.filter(_ == '*') match {
        case Some(_) => isMatch(s, p.drop(2)) || (firstMatch && isMatch(s.drop(1), p))
        case None => firstMatch && isMatch(s.drop(1), p.drop(1))
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(isMatch("abcd", "b*.*cd"))
  }
}
