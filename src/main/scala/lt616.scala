// https://leetcode.com/problems/add-bold-tag-in-string/
object lt616 {
  def addBoldTag(s: String, dict: Array[String]): String = {
    val bold = Array.fill(s.length)(false)
    var end = 0
    s.indices.foreach { i =>
      dict.foreach(d => {
        if (s.startsWith(d, i)) end = end max (i + d.length)
      })
      bold(i) = end > i
    }

    val ans = new StringBuilder
    var i = 0
    while (i < s.length) {
      if (!bold(i)) {
        ans.addOne(s(i))
        i += 1
      }
      else {
        var j = i
        while (j < s.length && bold(j)) j += 1
        ans.append("<b>").append(s.substring(i, j)).append("</b>")
        i = j
      }
    }
    ans.toString()
  }

  def main(args: Array[String]): Unit = {
    println(addBoldTag("abcxyz123", Array("abc", "123")))
  }
}
