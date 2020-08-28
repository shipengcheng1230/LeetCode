// https://leetcode.com/problems/group-shifted-strings/
object lt249 {
  def groupStrings(strings: Array[String]): List[List[String]] = {
    strings.groupBy(s => {
      if (s.length == 1) Seq(26) else
        s.toSeq.sliding(2, 1).map(x => (x(0) - x(1) + 26) % 26).toSeq
    }).values.map(_.toList).toList
  }
}
