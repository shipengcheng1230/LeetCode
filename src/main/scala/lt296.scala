// https://leetcode.com/problems/best-meeting-point/
object lt296 {
  def minTotalDistance(grid: Array[Array[Int]]): Int = {
    import scala.collection.mutable

    val m = grid.length
    val n = grid.head.length
    val rows = mutable.ArrayBuffer.empty[Int]
    val cols = mutable.ArrayBuffer.empty[Int]

    for (i <- 0 until m; j <- 0 until n; if grid(i)(j) == 1) {
      rows.addOne(i)
      cols.addOne(j)
    }
    // could be further optimized without sorting by changing collecting order
    val row = rows.sortInPlace()(Ordering[Int])(rows.length / 2)
    val col = cols.sortInPlace()(Ordering[Int])(cols.length / 2)

    rows.map(x => math.abs(x - row)).sum + cols.map(x => math.abs(x - col)).sum
  }
}
