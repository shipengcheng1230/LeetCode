// https://leetcode.com/problems/simplify-path/
object lt71 {
  def simplifyPath(path: String): String = {
    val stack = scala.collection.mutable.Stack.empty[String]
    path.split("/+") match {
      case x if x.isEmpty => "/"
      case x => x.tail.foreach({
        case "." =>
        case ".." => if (stack.nonEmpty) stack.pop()
        case x => stack.push(x)
      })
        stack.reverse.mkString("/", "/", "")
    }
  }
}
