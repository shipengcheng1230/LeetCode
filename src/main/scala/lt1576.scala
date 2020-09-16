// https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
object lt1576 {
  def modifyString(s: String): String = {
    var prev = '#'
    var after = '#'
    val sb = new StringBuilder
    s.zipWithIndex.foreach { case (c, i) =>
      if (c == '?') {
        after = if (i != s.length - 1) s(i + 1) else '#'
        val newChar = ((0 to 25).find(x =>{
          val y = (x + 'a').toChar
          y != prev && y != after
        }).get + 'a').toChar
        sb.addOne(newChar)
        prev = newChar
      } else {
        sb.addOne(c)
        prev = c
      }
    }
    sb.toString()
  }
}
