// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
object lt340 {
  def lengthOfLongestSubstringKDistinct(s: String, k: Int): Int = {
    // can use LinkedHashMap instead
    val index = scala.collection.mutable.Map.empty[Char, Int]
    var ans = 0
    var start = 0
    s.indices.foreach(i => {
      index.update(s(i), i)
      if (index.size > k) {
        val min = index.values.min
        start = min + 1
        index.remove(s(min))
      }
      ans = ans max (i - start + 1)
    })
    ans
  }
}
