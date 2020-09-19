// https://leetcode.com/problems/word-pattern/
object lt290 {
  def wordPattern(pattern: String, s: String): Boolean = {
    import scala.collection.mutable.Map

    val sl = s.split(" ")

    def backtrack(pi: Int, si: Int, map: Map[Char, String]): Boolean = {
      if (pi == pattern.length && si == sl.length) true
      else if (pi == pattern.length || si == sl.length) false
      else {
        val x = sl(si)
        if (map.contains(pattern(pi)) && map(pattern(pi)) == x) {
          if (backtrack(pi + 1, si + 1, map)) return true
        }
        if (!map.contains(pattern(pi)) && !map.values.exists(_ == x)) {
          map.update(pattern(pi), x)
          if (backtrack(pi + 1, si + 1, map)) return true
          map.remove(pattern(pi))
        }
        false
      }
    }

    backtrack(0, 0, Map.empty[Char, String])
  }
}
