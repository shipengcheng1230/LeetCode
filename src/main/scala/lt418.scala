object lt418 {
  def wordsTyping(sentence: Array[String], rows: Int, cols: Int): Int = {
    val n = sentence.length
    val dp = Array.fill(n)(0)
    for (i <- 0 until n) {
      var length = 0
      var words = 0
      var index = i
      while (length + sentence(index % n).length <= cols) {
        length += sentence(index % n).length
        length += 1
        index += 1
        words += 1
      }
      dp(i) = words
    }
    var words = 0
    var index = 0
    for (_ <- 0 until rows) {
      words += dp(index)
      index = (dp(index) + index) % n
    }
    words / n
  }

  def main(args: Array[String]): Unit = {
    print(wordsTyping(Array("f","p","a"), 8, 7))
  }
}
