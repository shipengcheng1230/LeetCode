// https://leetcode.com/problems/minimum-knight-moves/
object lt1197 {
  def minKnightMoves(x: Int, y: Int): Int = {
    import scala.collection.mutable
    val map = mutable.Map.empty[(Int, Int), Int]

    def helper(x: Int, y: Int): Int = {
      if (map.contains((x, y))) map((x, y))
      else {
        if (x + y == 0) 0
        else if (x + y == 2) 2
        else {
          val ret = math.min(helper(math.abs(x-1), math.abs(y-2)), helper(math.abs(x-2), math.abs(y-1))) + 1
          map.update((x, y), ret)
          ret
        }
      }
    }

    helper(math.abs(x), math.abs(y))
  }
}
