// https://leetcode.com/problems/verifying-an-alien-dictionary/
object lt953 {
  def isAlienSorted(words: Array[String], order: String): Boolean = {
    val map = order.indices.map(i => order(i) -> i).toMap.updated('0', -2).withDefaultValue(-1)

    def ordered(s1: String, s2: String): Boolean = {
      s1.zipAll(s2, '0', '0').foldLeft(true)((acc, x) => {
        if (map(x._1) == map(x._2)) acc
        else return map(x._1) < map(x._2)
      })
    }

    words.sliding(2, 1).forall(x => ordered(x.head, x.last))
  }
}
