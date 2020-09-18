// https://leetcode.com/problems/word-abbreviation/
object lt527 {
  def wordsAbbreviation(dict: List[String]): List[String] = {
    import scala.collection.mutable

    val ans = dict.toArray
    val string2index = dict.zipWithIndex.toMap

    def abbreviation(s: String, start: Int): String = {
      val n = s.length
      if (n <= 3 + start) s
      else s.substring(0, start + 1) + (n - 2 - start).toString + s.last
    }

    def helper(dict: List[String], start: Int): Unit = {
      if (dict.nonEmpty) {
        val abbrs = dict.groupBy(d => abbreviation(d, start))
        val (unique, multiple) = abbrs.partition(_._2.length == 1)
        unique.foreach { case (k, vs) => vs.foreach(v => ans(string2index(v)) = k) }
        helper(multiple.values.flatten.toList, start + 1)
      }
    }

    helper(dict, 0)
    ans.toList
  }

  // use trie and group by head, last and length
}
