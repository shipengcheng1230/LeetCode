object lt165 {
  def compareVersion(version1: String, version2: String): Int = {
    def toList(s: String): Array[Int] = s.split("\\.").map(_.toInt)

    val d = toList(version1).zipAll(toList(version2), 0, 0).dropWhile(c => c._1 == c._2)
    if (d.isEmpty) 0 else Math.signum(d.head._1.toFloat - d.head._2.toFloat).toInt
  }
}
