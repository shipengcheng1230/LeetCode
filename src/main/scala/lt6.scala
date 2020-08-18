// https://leetcode.com/problems/zigzag-conversion/
object lt6 {
  def convert(s: String, numRows: Int): String = {
    val sbs = (0 until numRows).map(_ => new StringBuilder)
    var remaining = s
    while (remaining.nonEmpty) {
      val (d, x) = remaining.splitAt(numRows)
      val (u, r) = x.splitAt(numRows - 2)
      d.zipWithIndex.foreach(i => sbs(i._2).append(i._1))
      u.zipWithIndex.foreach(i => sbs(numRows - i._2 - 2).append(i._1))
      remaining = r
    }
    sbs.reduce(_ append _).toString()
  }

  def main(args: Array[String]): Unit = {
    println(convert("PAYPALISHIRING", 3))
  }
}
