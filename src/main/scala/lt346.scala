object lt346 {
  class MovingAverage(_size: Int) {

    /** Initialize your data structure here. */
    import scala.collection.mutable.Queue

    val q = Queue.empty[Int]

    def next(`val`: Int): Double = {
      q.enqueue(`val`)
      if (q.size > _size) q.dequeue()
      q.sum.toDouble / q.size
    }
  }
}
