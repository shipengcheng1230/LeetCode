// https://leetcode.com/problems/contain-virus/
object lt749 {
  def containVirus(grid: Array[Array[Int]]): Int = {
    if (grid.isEmpty || grid.head.isEmpty) return 0

    import scala.collection.mutable

    val rows = grid.length
    val cols = grid.head.length
    var ans = 0

    class Region extends Ordered[Region] {
      val infected = mutable.Set.empty[Int]
      val uninfected = mutable.Set.empty[Int]
      var wallsRequired = 0

      override def compare(that: Region): Int =
        that.uninfected.size - uninfected.size
    }

    def dfs(row: Int, col: Int, visited: Array[Array[Boolean]], region: Region): Unit = {
      if (row < 0 || row >= rows || col < 0 || col >= cols || grid(row)(col) == 2) return
      if (grid(row)(col) == 1) {
        region.infected.add(row * cols + col)
        if (visited(row)(col)) return
      }
      visited(row)(col) = true
      if (grid(row)(col) == 0) {
        region.wallsRequired += 1
        region.uninfected.add(row * cols + col)
      } else {
        dfs(row + 1, col, visited, region)
        dfs(row - 1, col, visited, region)
        dfs(row, col - 1, visited, region)
        dfs(row, col + 1, visited, region)
      }
    }

    var break = true
    while (break) {
      val regions = mutable.ArrayDeque.empty[Region]
      val visited = Array.fill(rows, cols)(false)
      for { row <- 0 until rows; col <- 0 until cols; if !visited(row)(col) && grid(row)(col) == 1} {
        val region = new Region
        dfs(row, col, visited, region)
        if (region.uninfected.nonEmpty)
          regions.append(region)
      }
      if (regions.isEmpty)
        break = false
      else {
        regions.sortInPlace()
        val first = regions.removeHead()
        ans += first.wallsRequired
        first.infected.foreach(nei => {
          val r = nei / cols
          val c = nei % cols
          grid(r)(c) = 2
        })
        regions.foreach(region => {
          region.uninfected.foreach(nei => {
            val r = nei / cols
            val c = nei % cols
            grid(r)(c) = 1
          })
        })
      }
    }

    ans
  }

  def main(args: Array[String]): Unit = {
    println(containVirus(Array(
      Array(0,1,0,0,0,0,0,1),
      Array(0,1,0,0,0,0,0,1),
      Array(0,0,0,0,0,0,0,1),
      Array(0,0,0,0,0,0,0,0),
    )))
  }
}
