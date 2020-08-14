// https://leetcode.com/problems/longest-substring-without-repeating-characters/
object lt3 {
  def lengthOfLongestSubstring(s: String): Int = {
    import scala.collection.mutable
    val n = s.length
    var ans = 0
    val map = mutable.Map.empty[Char, Int]
    var start = 0
    s.indices.foreach(i => {
      if (map.contains(s(i))) {
        start = start max (map(s(i)) + 1)
      }
      ans = ans max (i - start + 1)
      map.update(s(i), i)
    })
    ans
  }
}
