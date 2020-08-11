// https://leetcode.com/problems/string-transforms-into-another-string/
object lt1153 {
  def canConvert(str1: String, str2: String): Boolean = {
    if (str1 == str2) true
    else {
      val map = scala.collection.mutable.Map.empty[Char, Char]
      str1.indices.foreach(i => {
        if (map.getOrElse(str1(i), str2(i)) != str2(i)) return false
        map.update(str1(i), str2(i))
      })
      map.values.toSet.size < 26
    }
  }
}
