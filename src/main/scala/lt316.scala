// https://leetcode.com/problems/remove-duplicate-letters/
object lt316 {
  import scala.util.control.Breaks._

  def removeDuplicateLetters(s: String): String = {
    if (s.isEmpty) "" else {
      val count = Array.fill(26)(0)
      s.foreach(c => count(c - 'a') += 1)
      var start = 0
      breakable {
        s.indices.foreach(i => {
          if (s(i) < s(start)) start = i
          count(s(i) - 'a') -= 1
          if (count(s(i) - 'a') == 0) break()
        })
      }
      s"${s(start)}${removeDuplicateLetters(s.substring(start + 1).replace(s(start).toString, ""))}"
    }
  }

  def main(args: Array[String]): Unit = {
    println(removeDuplicateLetters("cbacdcbc"))
  }
}
