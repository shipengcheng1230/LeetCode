import scala.collection.mutable

object lt295 {

  /** initialize your data structure here. */

  val lo = new mutable.PriorityQueue[Int]()
  val hi = new mutable.PriorityQueue[Int]()(Ordering[Int].reverse)

  def addNum(num: Int) {
    lo += num
    hi += lo.dequeue
    if (lo.size < hi.size) lo += hi.dequeue
  }

  def findMedian(): Double = {
    if (lo.size == hi.size) (lo.head + hi.head) / 2.0 else lo.head
  }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = new MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */