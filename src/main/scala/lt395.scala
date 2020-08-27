// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
object lt395 {
  def longestSubstring(s: String, k: Int): Int = {
    if (s.isEmpty) 0
    else {
      val count = Array.fill(26)(0)
      s.foreach(c => count(c - 'a') += 1)
      var flag = true
      count.foreach(x => if (x < k && x > 0) flag = false)
      if (flag) s.length else {
        var result = 0
        var start = 0
        var curr = 0
        while (curr < s.length) {
          if (count(s(curr) - 'a') < k) {
            result = math.max(result, longestSubstring(s.substring(start, curr), k))
            start = curr + 1
          }
          curr += 1
        }
        result = math.max(result, longestSubstring(s.substring(start), k))
        result
      }
    }
  }
}
