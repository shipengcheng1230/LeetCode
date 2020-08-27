// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
object lt1209 {
  def removeDuplicates(s: String, k: Int): String = {
    import scala.collection.mutable
    val stack = mutable.Stack.empty[(Char, Int)]
    s.foreach(c => {
      stack.headOption match {
        case None => stack.push((c, 1))
        case Some(x) =>
          if (c == x._1) stack.push((c, x._2 + 1))
          else stack.push((c, 1))
          if (stack.head._2 == k) (0 until k).foreach(_ => stack.pop())
      }
    })
    stack.map(_._1).reverse.mkString("")
  }

  def main(args: Array[String]): Unit = {
    println(removeDuplicates("deeedbbcccbdaa", 3))
  }
}
