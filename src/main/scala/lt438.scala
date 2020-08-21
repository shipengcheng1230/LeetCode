// https://leetcode.com/problems/find-all-anagrams-in-a-string/
object lt438 {
  def findAnagrams(s: String, p: String): List[Int] = {
    val map = p.groupMapReduce(identity)(_ => 1)(_ + _)
    s.zipWithIndex.view.foldLeft(Seq.empty[Int])((acc, x) => {
      if (map.contains(x._1) && x._2 + p.length <= s.length) {
        val map2 = s.substring(x._2, x._2 + p.length).groupMapReduce(identity)(_ => 1)(_ + _)
        if (map == map2) acc :+ x._2 else acc
      } else acc
    }).toList
  }
}
