// https://leetcode.com/problems/minimum-time-to-build-blocks/
object lt1199 {
  def minBuildTime(blocks: Array[Int], split: Int): Int = {
    val pq = scala.collection.mutable.PriorityQueue.empty[Int].reverse
    blocks.foreach(pq.addOne)
    while (pq.size > 1) {
      pq.dequeue()
      pq.addOne(pq.dequeue() + split)
    }
    pq.dequeue()
  }
}
