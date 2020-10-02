// https://leetcode.com/problems/shortest-word-distance-iii/
object lt245 {
  def shortestWordDistance(words: Array[String], word1: String, word2: String): Int = {
    var i = -1
    var j = -1
    var ans = Int.MaxValue
    words.zipWithIndex.foreach { case (w, k) =>
      if (word1 != word2) {
        if (w == word1) i = k
        if (w == word2) j = k
      } else {
        if (i == -1 && w == word1) i = k
        else if (i != -1 && j == -1 && w == word2) j = k
        else if (i != -1 && j != -1 && w == word2) { i = j; j = k }
      }
      if (i != -1 && j != -1) ans = ans min math.abs(i - j)
    }
    ans
  }
}
