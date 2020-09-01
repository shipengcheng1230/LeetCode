// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
object lt862 {
  def shortestSubarray(A: Array[Int], K: Int): Int = {
    import scala.collection.mutable.ArrayDeque

    val P = A.scanLeft(0)(_ + _)
    var ans = Int.MaxValue
    val q = ArrayDeque.empty[Int]
    P.indices.foreach(i => {
      while (q.nonEmpty && P(i) <= P(q.last))
        q.removeLast()
      while (q.nonEmpty && P(i) >= P(q.head) + K)
        ans = ans min (i - q.removeHead())
      q.append(i)
    })
    if (ans == Int.MaxValue) -1 else ans
  }
}
