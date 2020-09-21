// https://leetcode.com/problems/the-maze-iii/
object lt499 {
  def findShortestWay(maze: Array[Array[Int]], ball: Array[Int], hole: Array[Int]): String = {
    import scala.collection.mutable.{PriorityQueue, Set}

    case class Point(x: Int, y: Int, d: Int, path: String)

    implicit def ordering[A <: Point]: Ordering[A] = Ordering.by(p => (p.d, p.path))

    val m = maze.length
    val n = maze.head.length
    val dirs = List((0, 1, "r"), (0, -1, "l"), (-1, 0, "u"), (1, 0, "d"))
    val pq = PriorityQueue.empty[Point].reverse
    val visited = Array.fill(m, n)(false)
    pq.enqueue(Point(ball(0), ball(1), 0, ""))

    // put it into a function in order to early return for special case, like hitting hole
    def forward(point: Point, d: (Int, Int, String)): Point = {
      var nx = point.x
      var ny = point.y
      var dist = point.d
      while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze(nx)(ny) == 0) {
        nx += d._1
        ny += d._2
        dist += 1
        if (nx == hole(0) && ny == hole(1)) return Point(nx, ny, dist, point.path + d._3)
      }
      nx -= d._1
      ny -= d._2
      dist -= 1
      Point(nx, ny, dist, point.path + d._3)
    }

    while (pq.nonEmpty) {
      val p = pq.dequeue()
      if (p.x == hole(0) && p.y == hole(1)) return p.path
      if (!visited(p.x)(p.y)) {
        visited(p.x)(p.y) = true
        dirs.foreach(d => {
          val next = forward(p, d)
          pq.enqueue(next)
        })
      }
    }

    "impossible"
  }

  def main(args: Array[String]): Unit = {
    println(findShortestWay(
      Array(
        Array(0,0,0,0,0),
        Array(1,1,0,0,1),
        Array(0,0,0,0,0),
        Array(0,1,0,0,1),
        Array(0,1,0,0,0),
      ), Array(4, 3), Array(0, 1)
    ))
  }
}
