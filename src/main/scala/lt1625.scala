// https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/
object lt1625 {
  def findLexSmallestString(s: String, a: Int, b: Int): String = {

    import scala.collection.mutable.{Set, Queue}

    val seen = Set.empty[String].addOne(s)
    val q = Queue.empty[String].enqueue(s)
    val n = s.length
    var ans = s

    def rotate(s: String): String =
      s.takeRight(b) ++ s.take(n - b)

    def add(s: String): String = s
      .map(_.asDigit).zipWithIndex
      .map(x => if (x._2 % 2 == 1) (x._1 + a) % 10 else x._1)
      .mkString("")

    while (q.nonEmpty) {
      val x = q.dequeue()
      if (Ordering[String].compare(x, ans) < 0) ans = x

      val a = rotate(x)
      if (seen.add(a)) q.enqueue(a)
      val b = add(x)
      if (seen.add(b)) q.enqueue(b)
    }

    ans
  }
}
