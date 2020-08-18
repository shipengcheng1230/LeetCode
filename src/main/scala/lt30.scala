// https://leetcode.com/problems/substring-with-concatenation-of-all-words/
object lt30 {
  def findSubstring(s: String, words: Array[String]): List[Int] = {
    if (s.isEmpty || words.isEmpty) Nil else {
      def group(s: Seq[String]) = s.groupMapReduce(identity)(_ => 1)(_ + _)

      val target = group(words.toIndexedSeq)
      val m = words.head.length
      val n = m * words.length

      (0 to (s.length - n)).filter(i => {
        group(s.substring(i, i + n).toSeq.sliding(m, m).map(_.unwrap).toSeq) == target
      }).toList

      // check feasibility at runtime to avoid repeating:
      // https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13658/Easy-Two-Map-Solution-(C%2B%2BJava)
    }
  }

  def main(args: Array[String]): Unit = {
    println(findSubstring("wordgoodgoodgoodbestword", Array("word","good","best","good")))
    println(findSubstring("barfoothefoobarman", Array("foo", "bar")))
    println(findSubstring("wordgoodgoodgoodbestword", Array("word","good","best","word")))
  }
}
