object lt564 {
  def nearestPalindromic(n: String): String = {

    import scala.collection.mutable
    val l = n.length
    val candidates = mutable.Set.empty[String]
    candidates.addOne((math.pow(10, l).longValue  + 1).toString)
    candidates.addOne((math.pow(10, l-1).longValue - 1).toString)
    val prefix = n.take((l+1)/2).toLong
    for (i <- -1 to 1) {
      val s1 = (prefix + i).toString
      val s2 = if (l % 2 == 0) s1 + s1.reverse else s1 + s1.dropRight(1).reverse
      candidates.addOne(s2)
    }
    candidates.remove(n)
    candidates.minBy(s => (math.abs(s.toLong - n.toLong), s.toLong))
  }

  def main(args: Array[String]): Unit = {
    print(nearestPalindromic("2147483647"))
  }
}
