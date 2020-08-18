// https://leetcode.com/problems/sliding-puzzle/
object lt773 {
  def slidingPuzzle(board: Array[Array[Int]]): Int = {
    import scala.collection.mutable

    val target = "123450"
    val q = mutable.Queue.empty[String]
    val seen = mutable.Set.empty[String]
    val start = board.flatten.mkString
    val dirs = List(List(1,3), List(0,2,4), List(1,5), List(0,4), List(1,3,5), List(2,4))
    q.enqueue(start)
    seen.add(start)
    var step = 0
    while (q.nonEmpty) {
      q.dequeueAll(_ => true).foreach(p => {
        if (p == target) return step
        val zero = p.indexOf('0')
        dirs(zero).foreach(d => {
          val next = swap(p, zero, d)
          if (!seen.contains(next)) {
            seen.add(next)
            q.enqueue(next)
          }
        })
      })
      step += 1
    }
    -1
  }

  def swap(s: String, i: Int, j: Int): String = {
    val sb = new StringBuilder(s)
    sb(i) = s(j)
    sb(j) = s(i)
    sb.toString()
  }
}
