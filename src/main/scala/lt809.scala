object lt809 {
  def expressiveWords(S: String, words: Array[String]): Int = {
    if (S.isEmpty || words.isEmpty) return 0
    words.map(x => stretchy(S, x)).count(x => x)
  }

  def stretchy(S: String, word: String): Boolean = {
    if (word.isEmpty) false
    else {
      var i = 0
      var j = 0
      while(i < S.length && j < word.length) {
        if (S(i) == word(j)) {
          val len1 = getRepeatedLength(S, i)
          val len2 = getRepeatedLength(word, j)
          if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) return false
          i += len1
          j += len2
        } else return false
      }
      i == S.length && j == word.length
    }
  }

  def getRepeatedLength(str: String, i: Int): Int = {
    var j = i
    while (j < str.length && str(j) == str(i)) {
      j += 1
    }
    j - i
  }
}
