// https://leetcode.com/problems/high-five/
object lt1086 {
  def highFive(items: Array[Array[Int]]): Array[Array[Int]] = {
    import scala.collection.mutable

    val map = mutable.Map.empty[Int, mutable.PriorityQueue[Int]]
    items.foreach(item => {
      if (!map.contains(item.head))
        map.update(item.head, mutable.PriorityQueue.empty[Int].reverse)
      val record = map(item.head)
      record.enqueue(item.last)
      if (record.size > 5)
        record.dequeue()
    })
    map.map(x => Array(x._1, x._2.sum / x._2.size)).toArray.sortBy(_(0))
  }
}
