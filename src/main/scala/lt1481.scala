// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
object lt1481 {
  def findLeastNumOfUniqueInts(arr: Array[Int], k: Int): Int = {
    import scala.collection.mutable.Map

    val count = arr.groupMapReduce(identity)(_ => 1)(_ + _).to(Map)
    var remain = k
    count.toSeq.sortBy(_._2).foreach { case (n, c) =>
      if (remain > c) {
        remain -= c
        count.remove(n)
      } else if (remain == c) return count.size - 1
      else return count.size
    }
    0
  }
}
