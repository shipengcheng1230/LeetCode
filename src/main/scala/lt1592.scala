// https://leetcode.com/problems/rearrange-spaces-between-words/
object lt1592 {
  def reorderSpaces(text: String): String = {
    val nspace = text.count(_ == ' ')
    val ss = text.trim.split("\\s+")
    if (ss.length == 1) return ss.head + " " * (text.length - ss.head.length)
    val a = nspace / (ss.length - 1)
    val b = nspace - a * (ss.length - 1)
    ss.mkString(" " * a) + " " * b
  }
}
