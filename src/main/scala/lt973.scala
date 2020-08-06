object lt973 {

  case class Point(point: Array[Int], dist: Int)

  def kClosest(points: Array[Array[Int]], K: Int): Array[Array[Int]] = {
    // one line solution
    // points zip points.map(point => math sqrt (math.pow(point.head, 2) + math.pow(point.last, 2))) sortBy (_._2) take K map (_._1)

    import scala.collection.mutable

    val q = mutable.PriorityQueue.empty[Point](Ordering.by(_.dist))
    points.foreach(p => {
      q.enqueue(Point(p, p(0)*p(0)+p(1)*p(1)))
      if (q.length > K) q.dequeue()
    })
    q.dequeueAll.map({ x: Point => x.point }).toArray
  }
}
