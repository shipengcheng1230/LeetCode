// https://leetcode.com/problems/longest-string-chain/
object lt1048 {
  def longestStrChain(words: Array[String]): Int = {
    val map = words.map(_ -> 1).to(scala.collection.mutable.Map).withDefaultValue(0)
    var res = 0
    words.sortBy(_.length).foreach(word => {
      word.indices.foreach(i => {
        map.update(word, map(word) max (map(word.substring(0, i) + word.substring(i + 1)) + 1))
        res = res max map(word)
      })
    })
    res
  }
}
