// https://leetcode.com/problems/reorganize-string/
object lt767 {
  def reorganizeString(S: String): String = {
    val count = S.groupMapReduce(identity)(_ => 1)(_ + _)
    if (count.maxBy(_._2)._2 > (S.length + 1) / 2) ""
    else {
      val ans = Array.fill[Char](S.length)('0')
      val a = S.toSeq.sortBy(x => (-count(x), x))
      (0 until (S.length + 1) / 2).foreach(i => ans(2 * i) = a(i))
      (0 until S.length / 2).foreach(i => ans(2 * i + 1) = a(i + (S.length + 1) / 2))
      ans.mkString("")
    }
  }

  def main(args: Array[String]): Unit = {
    println(reorganizeString("abbabbaaab"))
  }
}
