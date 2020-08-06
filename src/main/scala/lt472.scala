object lt472 {

  def findAllConcatenatedWordsInADict(words: Array[String]): List[String] = {

    import scala.collection.mutable
    import scala.util.control.Breaks._

    val res = mutable.ListBuffer.empty[String]
    val preWordSet = mutable.Set.empty[String]

    def check(word: String): Boolean = {
      if (preWordSet.isEmpty) false else {
        val dp = Array.fill[Boolean](word.length + 1)(false)
        dp(0) = true
        (1 to word.length).foreach(i => {
          breakable {
            for (j <- 0 until i; if (dp(j))) {
              if (preWordSet.contains(word.substring(j, i))) {
                dp(i) = true
                break
              }
            }
          }
        })
        dp.last
      }
    }

    for (word <- words.sortBy(_.length)) {
      if (check(word)) res.append(word)
      preWordSet.addOne(word)
    }

    res.toList
  }
}