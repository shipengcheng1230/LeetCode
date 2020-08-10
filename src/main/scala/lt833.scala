// https://leetcode.com/problems/find-and-replace-in-string/
object lt833 {
  def findReplaceString(S: String, indexes: Array[Int], sources: Array[String], targets: Array[String]): String = {
    val sb = new StringBuilder(S)
    val invert = Array.fill(S.length)(-1)
    indexes.indices.foreach(i => invert(indexes(i)) = i)
    for (i <- S.length - 1 to 0 by -1 if invert(i) >= 0) {
      val j = invert(i)
      if (S.substring(indexes(j)).startsWith(sources(j))) {
        sb.replace(indexes(j), indexes(j) + sources(j).length, targets(j))
      }
    }
    sb.toString()
  }
}
