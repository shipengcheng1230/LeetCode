// https://leetcode.com/problems/zigzag-iterator/submissions/
object lt281 {
  class ZigzagIterator(_v1: Array[Int], _v2: Array[Int]) {
    /** initialize your data structure here. */

    import scala.collection.mutable.Queue

    val q = Queue.empty[Iterator[Int]]
    if (_v1.nonEmpty) q.enqueue(_v1.iterator)
    if (_v2.nonEmpty) q.enqueue(_v2.iterator)


    def next(): Int = {
      val curr = q.dequeue()
      val ans = curr.next()
      if (curr.hasNext) q.enqueue(curr)
      ans
    }

    def hasNext(): Boolean = {
      q.nonEmpty
    }
  }
}
