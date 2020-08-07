object lt394 {

  import scala.collection.mutable
  import scala.annotation.tailrec

  @tailrec
  def helper(remaining: String, chars: mutable.Stack[String]): String = {
    remaining.headOption match {
      case None => chars.reverse.mkString
      case Some(head) => head match {
        case h if h.isLetter || h.isDigit || h == '[' => helper(remaining.tail, chars.push(h.toString))
        case h if h == ']' =>
          val charSeq = chars.popWhile(_ != "[")
          chars.pop()
          val numSeq = chars.popWhile(_.matches("[0-9]"))
          val num = numSeq.reverse.mkString.toInt
          val result = charSeq.reverse.mkString * num
          helper(remaining.tail, chars.push(result))
      }
      case _ => helper(remaining.tail, chars)
    }
  }

  def decodeString(s: String): String = {
    helper(s, mutable.Stack.empty[String])
  }
}
