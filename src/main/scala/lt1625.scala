// https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/
object lt1625 {
  def findLexSmallestString(s: String, a: Int, b: Int): String = {

    import scala.collection.mutable.Set

    val seen = Set.empty[String]

    def rotate(s: String, b: Int): String =
      s.takeRight(b) ++ s.take(s.length - b)

    def add(s: String, a: Int): String = {
      s.map(_.asDigit).zipWithIndex.map(x => if (x._2 % 2 == 1) (x._1 + a) % 10 else x._1).mkString("")
    }

    def dfs(s: String): String = {
      seen.contains(s) match {
        case false =>
          seen.addOne(s)
          dfs(rotate(s, b))
          dfs(add(s, a))
        case true =>
          seen.min
      }
    }

    dfs(s)
  }

  def main(args: Array[String]): Unit = {
    findLexSmallestString("5525", 9, 2)
  }
}
