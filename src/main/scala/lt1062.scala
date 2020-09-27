// https://leetcode.com/problems/longest-repeating-substring/
object lt1062 {
  import scala.collection.mutable

  def longestRepeatingSubstring(S: String): Int = {
    val n = S.length
    var left = 1
    var right = n
    while (left <= right) {
      val mid = left + (right - left) / 2
      if (search(mid, S) != -1) left = mid + 1
      else right = mid - 1
    }
    left - 1
  }

  def search(l: Int, s: String): Int = {
    val seen = mutable.Set.empty[String]
    for (start <- 0 to s.length - l) {
      val tmp = s.substring(start, start + l)
      if (!seen.contains(tmp)) seen.addOne(tmp)
      else return start
    }
    -1
  }
}
