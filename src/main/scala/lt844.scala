// https://leetcode.com/problems/backspace-string-compare/
object lt844 {
  def backspaceCompare(S: String, T: String): Boolean = {
    import scala.collection.mutable
    val ss = mutable.Stack.empty[Char]
    val tt = ss.clone()
    S.foreach {
      case '#' => if (ss.nonEmpty) ss.pop()
      case c => ss.push(c)
    }
    T.foreach {
      case '#' => if (tt.nonEmpty) tt.pop()
      case c => tt.push(c)
    }
    ss == tt
  }
}
