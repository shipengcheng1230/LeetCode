// https://leetcode.com/problems/shortest-word-distance/
object lt243 {
  def shortestDistance(words: Array[String], word1: String, word2: String): Int = {
    var i = -1
    var j = -1
    var ans = words.length
    words.indices.foreach(k => {
      if (words(k) == word1) i = k
      if (words(k) == word2) j = k
      if (i != -1 && j != -1) ans = ans min math.abs(i - j)
    })
    ans
  }
}
