// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/submissions/
object lt524 {
  def findLongestWord(s: String, d: List[String]): String = {
    var candidate = ""

    def isDelete(word: String): Boolean = {
      var i = 0
      var j = 0
      while (i < s.length && j < word.length) {
        if (s(i) == word(j)) j += 1
        i += 1
      }
      j == word.length
    }

    d.foreach(word => {
      if (isDelete(word)) {
        if (word.length > candidate.length) candidate = word
        else if (word.length == candidate.length)
          if (Ordering[String].compare(candidate, word) > 0) candidate = word
      }

    })
    candidate
  }
}
