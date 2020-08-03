object lt127 {
  import scala.collection._

  def isNeighbour(s1: String, s2: String): Boolean = {
    var count = 0
    for(i <- 0 until s1.length) {
      if (s1(i) != s2(i)) count += 1
      if (count > 1) return false
    }
    count == 1
  }
  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
    val neighbourLookup = (beginWord :: wordList).map(s => s -> wordList.filter(t => isNeighbour(s, t))).toMap
    val visitedBegin = mutable.Set.empty[String]
    val visitedEnd = mutable.Set.empty[String]
    val queueBegin = mutable.Queue(beginWord)
    val queueEnd = mutable.Queue(endWord)

    var step = 0
    while(queueBegin.nonEmpty && queueEnd.nonEmpty) {
      val numLevelBegin = queueBegin.size
      for(i <- 0 until numLevelBegin) {
        val current = queueBegin.dequeue()
        if(visitedEnd.contains(current)) return 2 * step
        visitedBegin += current
        val children = neighbourLookup(current).filterNot(visitedBegin)
        queueBegin ++= children
      }

      val numLevelEnd = queueEnd.size
      for(i <- 0 until numLevelEnd) {
        val current = queueEnd.dequeue()
        if(visitedBegin.contains(current)) return 2 * step + 1
        visitedEnd += current
        if(!neighbourLookup.contains(current)) return 0
        val children = neighbourLookup(current).filterNot(visitedEnd)
        queueEnd ++= children
      }
      step += 1
    }
    0
  }

  def main(args: Array[String]): Unit = {
    println(ladderLength("hit", "cog", List("cog")))
  }
}
