// https://leetcode.com/problems/first-unique-character-in-a-string/
object lt387 {
  def firstUniqChar(s: String): Int = {
    val count = Array.fill('z' + 1)(0)
    s.foreach(count(_) += 1)
    s.indexWhere(count(_) == 1)
  }

  def main(args: Array[String]): Unit = {
    println(firstUniqChar("leetcode"))
  }
}
