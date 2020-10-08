// https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/
object lt1606 {
  def busiestServers(k: Int, arrival: Array[Int], load: Array[Int]): List[Int] = {
    import scala.collection.mutable.{PriorityQueue, TreeSet}

    val count = Array.fill(k)(0)
    val available = TreeSet.empty[Int]
    var maxCount = Int.MinValue
    available.addAll(0 until k)

    // endTime, indice
    val busy = PriorityQueue.empty[(Int, Int)](Ordering.by(-_._1))
    for (i <- arrival.indices) {
      while (busy.nonEmpty && busy.head._1 <= arrival(i))
        available.add(busy.dequeue()._2)

      if (available.nonEmpty) {
        val remain = available.rangeFrom(i % k)
        val assign = if (remain.isEmpty) available.head else remain.head
        available.remove(assign)
        count(assign) += 1
        maxCount = maxCount max count(assign)
        busy.enqueue((arrival(i) + load(i), assign))
      }
    }

    count.indices.filter(i => count(i) == maxCount).toList
  }
}
