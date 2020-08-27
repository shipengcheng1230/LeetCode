// https://leetcode.com/problems/water-and-jug-problem/
object lt365 {
  def canMeasureWater(x: Int, y: Int, z: Int): Boolean = {
    import scala.collection.mutable
    type state = (Int, Int)
    val q = mutable.Queue.empty[state]
    val seen = mutable.Set.empty[state]
    q.enqueue((0, 0))
    seen.addOne((0, 0))
    while (q.nonEmpty) {
      q.dequeueAll(_ => true).foreach(p => {
        if (p._1 == z || p._2 == z || p._1 + p._2 == z) return true

        if (!seen.contains((0, p._2))) {
          q.enqueue((0, p._2)); seen.addOne(q.last)
        }
        if (!seen.contains((p._1, 0))) {
          q.enqueue((p._1, 0)); seen.addOne(q.last)
        }
        if (p._1 <= y - p._2 && !seen.contains((0, p._1 + p._2))) {
          q.enqueue((0, p._1 + p._2)); seen.addOne(q.last)
        }
        if (p._1 > y - p._2 && !seen.contains((p._1 - y + p._2, y))) {
          q.enqueue((p._1 - y + p._2, y)); seen.addOne(q.last)
        }
        if (p._2 <= x - p._1 && !seen.contains((p._1 + p._2, 0))) {
          q.enqueue((p._1 + p._2, 0)); seen.addOne(q.last)
        }
        if (p._2 > x - p._1 && !seen.contains((x, p._2 - x + p._1))) {
          q.enqueue((x, p._2 - x + p._1)); seen.addOne(q.last)
        }
        if (!seen.contains((x, p._2))) {
          q.enqueue((x, p._2)); seen.addOne(q.last)
        }
        if (!seen.contains((p._1, y))) {
          q.enqueue((p._1, y)); seen.addOne(q.last)
        }
      })
    }
    false
  }
}
