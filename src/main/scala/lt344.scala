// https://leetcode.com/problems/reverse-string/
object lt344 {
  def reverseString(s: Array[Char]): Unit = {
    (0 until s.length / 2).foreach(i => {
      val tmp = s(i)
      s(i) = s(s.length - i - 1)
      s(s.length - i - 1) = tmp
    })
  }
}
