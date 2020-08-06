object lt1167 {
  def connectSticks(sticks: Array[Int]): Int = {
    import scala.collection.mutable

    val q = mutable.PriorityQueue.empty[Int].reverse
    q.enqueue(sticks: _*)
    var cost = 0
    while (q.size > 1) {
      val n1 = q.dequeue()
      val n2 = q.dequeue()
      cost += n1 + n2
      q.enqueue(n1 + n2)
    }
    cost
  }
}
