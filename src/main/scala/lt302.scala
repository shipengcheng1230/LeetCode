// https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/
object lt302 {
  def minArea(image: Array[Array[Char]], x: Int, y: Int): Int = {
    if (image.isEmpty || image.head.isEmpty) 0
    else {
      val m = image.length
      val n = image.head.length
      val rows = Array.tabulate(m)(i => image(i).map(_.asDigit).sum)
      val cols = Array.tabulate(n)(i =>
        image.foldLeft(0)((acc, x) => acc + x(i).asDigit))

      val x1 = (rows.indexWhere(_ != 0), rows.lastIndexWhere(_ != 0))
      val x2 = (cols.indexWhere(_ != 0), cols.lastIndexWhere(_ != 0))
      (x2._2 - x2._1 + 1) * (x1._2 - x1._1 + 1)
    }
  }
}
