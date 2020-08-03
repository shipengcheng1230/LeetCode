object lt140 {

  case class Memo[K, V](f: K => V) extends (K => V) {
    val cache = scala.collection.mutable.HashMap.empty[K, V]
    def apply(x: K): V = cache.getOrElseUpdate(x, f(x))
  }

  def wordBreak(s: String, wordDict: List[String]): List[String] = {

    lazy val memo: Memo[String, List[String]] = Memo {
      case "" => List("")
      case r => wordDict.foldLeft(List("")) {
        (l, w) => {
          if (r.endsWith(w)) {
            val left = memo(r.dropRight(w.length))
            if (left.nonEmpty) l ::: left.map(str => if (str.nonEmpty) str + " " + w else w)
            else l
          } else l
        }
      }
    }
    memo(s)
  }

  def main(args: Array[String]): Unit = {
    print(wordBreak("pineapplepenapple", List("apple", "pen", "applepen", "pine", "pineapple")))
  }
}
