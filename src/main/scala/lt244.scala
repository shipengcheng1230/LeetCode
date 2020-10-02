// https://leetcode.com/problems/shortest-word-distance-ii/
object lt244 {
  class WordDistance(_words: Array[String]) {
    import scala.collection.mutable.{Map, ListBuffer}

    val cache = Map.empty[String, ListBuffer[Int]]
    _words.zipWithIndex.foreach { case (w, i) =>
      cache.getOrElseUpdate(w, ListBuffer.empty[Int]).addOne(i)
    }

    def shortest(word1: String, word2: String): Int = {
      var i = 0
      var j = 0
      val l1 = cache(word1)
      val l2 = cache(word2)
      var ans = Int.MaxValue
      while (i < l1.length && j < l2.length) {
        ans = ans min math.abs(l1(i) - l2(j))
        if (l1(i) < l2(j)) i += 1 else j += 1
      }
      ans
    }
  }
}
