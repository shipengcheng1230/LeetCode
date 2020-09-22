// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
object lt1593 {
  def maxUniqueSplit(s: String): Int = {
    import scala.collection.mutable.Set

    def helper(s: String, set: Set[String]): Int = {
      var ans = 0
      for (i <- 1 to s.length) {
        val candidate = s.substring(0, i)
        if (!set.contains(candidate)) {
          set.add(candidate)
          ans = ans max (1 + helper(s.substring(i), set))
          set.remove(candidate)
        }
      }
      ans
    }

    helper(s, Set.empty[String])
  }
}
