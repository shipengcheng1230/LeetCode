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

  def minArea2(image: Array[Array[Char]], x: Int, y: Int): Int = {
    if (image.isEmpty || image.head.isEmpty) 0
    else {
      val m = image.length
      val n = image.head.length

      def searchColumns(i: Int, j: Int, top: Int, bottom: Int, whiteToBlack: Boolean): Int = {
        var (ii, jj) = (i, j)
        while (ii != jj) {
          var k = top
          val mid = (ii + jj) / 2
          while (k < bottom && image(k)(mid) == '0') k += 1
          // because the black pixels are connected, check the left part
          if (k < bottom == whiteToBlack) jj = mid
          // since there is a break col, check the right part
          else ii = mid + 1
        }
        ii
      }

      def searchRows(i: Int, j: Int, left: Int, right: Int, whiteToBlack: Boolean): Int = {
        var (ii, jj) = (i, j)
        while (ii != jj) {
          var k = left
          val mid = (ii + jj) / 2
          while (k < right && image(mid)(k) == '0') k += 1
          if (k < right == whiteToBlack) jj = mid
          else ii = mid + 1
        }
        ii
      }

      val left = searchColumns(0, y, 0, m, true)
      val right = searchColumns(y + 1, n, 0, m, false)
      val top = searchRows(0, x, left, right, true)
      val bottom = searchRows(x + 1, m, left, right, false)
      (right - left) * (bottom - top)
    }
  }
}
