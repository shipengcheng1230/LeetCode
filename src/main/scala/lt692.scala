object lt692 {
  def topKFrequent(words: Array[String], k: Int): List[String] = {
    // one-line-solution
    // words.groupBy(identity).view.mapValues(_.length).toSeq.sortBy(x => (-x._2, x._1)).map(_._1).take(k).toList

    import scala.collection.mutable

    val map = words.foldLeft(Map.empty[String, Int])((acc, x) => acc.updated(x, acc.getOrElse(x, 0) + 1))
    val heap = mutable.PriorityQueue.empty[(String, Int)](
      Ordering.by[(String,Int), Int](x => x._2)
        .orElse(Ordering.by[(String, Int), String](x => x._1).reverse))
    heap.enqueue(map.toSeq: _*)
    for (_ <- (1 to k).toList) yield heap.dequeue()._1 // only dequeue/dequeueAll ensure order, `take` does not
  }
}
