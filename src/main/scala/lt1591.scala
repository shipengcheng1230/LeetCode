// https://leetcode.com/problems/strange-printer-ii/
object lt1591 {
  def isPrintable(grid: Array[Array[Int]]): Boolean = {

    import scala.collection.mutable.Set

    val m = grid.length
    val n = grid.head.length

    val pos = Array.fill(61)(Array(m, n, 0, 0))
    val colors = Set.empty[Int]

    for (i <- 0 until m; j <- 0 until n) {
      val c = grid(i)(j)
      colors.addOne(c)
      pos(c)(0) = pos(c)(0) min i
      pos(c)(1) = pos(c)(1) min j
      pos(c)(2) = pos(c)(2) max i
      pos(c)(3) = pos(c)(3) max j
    }

    def test(c: Int): Boolean = {
      for (i <- pos(c)(0) to pos(c)(2); j <- pos(c)(1) to pos(c)(3)) {
        if (grid(i)(j) > 0 && grid(i)(j) != c) return false
      }
      for (i <- pos(c)(0) to pos(c)(2); j <- pos(c)(1) to pos(c)(3)) {
        grid(i)(j) = 0
      }
      true
    }

    while (colors.nonEmpty) {
      val painted = colors.filter(test)
      if (painted.isEmpty) return false else colors.subtractAll(painted)
    }

    grid.map(_.sum).sum == 0
  }
}
