// https://leetcode.com/problems/word-squares/
object lt425 {
  def wordSquares(words: Array[String]): List[List[String]] = {
    import scala.collection.mutable.{ListBuffer, Map}

    val n = words.head.length
    val ans = ListBuffer.empty[List[String]]

    val prefixMap = Map.empty[String, ListBuffer[String]]
    words.foreach { case (w) =>
      w.indices.init.foreach { case (i) =>
        val prefix = w.substring(0, i + 1)
        prefixMap.
          update(prefix, prefixMap.getOrElse(prefix, ListBuffer.empty[String]).addOne(w))
      }
    }

    def backtrack(res: ListBuffer[String]): Unit = {
      if (res.length == n) ans.append(res.toList)
      else {
        val step = res.length
        val prefix = res.map(_(step)).mkString("")
        prefixMap.get(prefix).foreach(l => {
          l.foreach(w => {
            res.append(w)
            backtrack(res)
            res.trimEnd(1)
          })
        })
      }
    }

    words.foreach(word => backtrack(ListBuffer(word)))
    ans.toList
  }
}
