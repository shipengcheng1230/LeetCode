// https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
object lt1297 {
  def maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int = {
    import scala.collection.mutable.Map

    var ans = Map.empty[String, Int]
    for {
      start <- 0 to s.length - minSize
      len <- minSize to (maxSize min s.length - start)
    } {
      val x = s.substring(start, start + len)
      if (x.toSet.size <= maxLetters) ans.update(x, ans.getOrElse(x, 0) + 1)
    }
    if (ans.isEmpty) 0 else ans.values.max
  }
}
