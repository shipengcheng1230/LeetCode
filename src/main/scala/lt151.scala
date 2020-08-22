// https://leetcode.com/problems/reverse-words-in-a-string/
object lt151 {
  def reverseWords(s: String): String = {
    if(s == null || s.length == 0) s
    else s.split(' ').filter(_.length > 0).reverse.mkString(" ")
  }
}
