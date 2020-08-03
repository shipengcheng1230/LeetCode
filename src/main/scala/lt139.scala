object lt139 {
  def wordBreak(s: String, wordDict: List[String]): Boolean = {

    import scala.collection.mutable.HashMap

    val memo = HashMap[String, Boolean]()

    def recursion(s: String): Boolean = {
      if (s.isEmpty) true
      else memo.getOrElseUpdate(s, wordDict.exists(prefix => {
        if (s.startsWith(prefix)) recursion(s.substring(prefix.length))
        else false
      }))
    }

    recursion(s)
  }
}
