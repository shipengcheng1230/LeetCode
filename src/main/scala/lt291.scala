// https://leetcode.com/problems/word-pattern-ii/
object lt291 {
  def wordPatternMatch(pattern: String, str: String): Boolean = {
    import scala.collection.mutable.Map

    def backtrack(pi: Int, si: Int, map: Map[Char, String]): Boolean = {
      if (pi == pattern.length && si == str.length) true
      else if (pi == pattern.length || si == str.length) false
      else {
        val c = pattern(pi)
        for (i <- si until str.length) {
          val sub = str.substring(si, i + 1)
          if (map.contains(c) && map(c) == sub) {
            if (backtrack(pi + 1, i + 1, map)) return true
          }
          if (!map.contains(c) && !map.values.exists(_ == sub)) {
            map.update(c, sub)
            if (backtrack(pi + 1, i + 1, map)) return true
            map.remove(c)
          }
        }
        false
      }
    }

    backtrack(0, 0, Map.empty[Char, String])
  }
}
