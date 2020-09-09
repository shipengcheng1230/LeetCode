// https://leetcode.com/problems/campus-bikes-ii/
object lt1066 {
  def assignBikes(workers: Array[Array[Int]], bikes: Array[Array[Int]]): Int = {
    import scala.collection.mutable

    def distance(i: Int, j: Int): Int =
      math.abs(workers(i)(0) - bikes(j)(0)) + math.abs(workers(i)(1) - bikes(j)(1))

    // mask binary represents which bikes are taken already
    case class Node(worker: Int, mask: Int, cost: Int)

    val pq = mutable.PriorityQueue.empty[Node](Ordering.by(_.cost)).reverse
    val seen = mutable.Set.empty[String]
    pq.enqueue(Node(0, 0, 0))
    while (pq.nonEmpty) {
      val curr = pq.dequeue()
      val key = s"#${curr.worker}#${curr.mask}"
      if (!seen.contains(key)) {
        seen.add(key)
        // meet the lowest cost first
        if (curr.worker == workers.length) return curr.cost
        bikes.indices.foreach(j => {
          if ((curr.mask & (1 << j)) == 0) {
            pq.enqueue(Node(curr.worker + 1, curr.mask | (1 << j), curr.cost + distance(curr.worker, j)))
          }
        })
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    println(assignBikes(Array(Array(0,0), Array(2,1)), Array(Array(1,2), Array(3,3))))
  }
}
