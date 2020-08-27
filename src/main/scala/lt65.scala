// https://leetcode.com/problems/valid-number/
object lt65 {
  def isNumber(s: String): Boolean = {
    import util.{Try, Success, Failure}
    Try(s.toDouble) match {
      case Success(_) => s.filter(_.isLetter).forall(_.toLower == 'e')
      case Failure(_) => false
    }
  }
}
