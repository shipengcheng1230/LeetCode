// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
object lt159 {
  def lengthOfLongestSubstringTwoDistinct(s: String): Int = {
    val index = scala.collection.mutable.Map.empty[Char, Int]
    var ans = 0
    var start = 0
    s.indices.foreach(i => {
      index.update(s(i), i)
      if (index.size > 2) {
        val min = index.values.min
        start = min + 1
        index.remove(s(min))
      }
      ans = ans max (i - start + 1)
    })
    ans
  }
}
