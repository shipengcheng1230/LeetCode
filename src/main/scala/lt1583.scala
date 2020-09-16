// https://leetcode.com/problems/count-unhappy-friends/
object lt1583 {
  def unhappyFriends(n: Int, preferences: Array[Array[Int]], pairs: Array[Array[Int]]): Int = {
    val pairMap = pairs.foldLeft(Map.empty[Int, Int]) { case (acc, pair) =>
      acc + (pair(0) -> pair(1)) + (pair(1) -> pair(0))
    }

    val ans = scala.collection.mutable.Set.empty[Int]

    pairMap.foreach { case (x, y) =>
      var i = 0
      val px = preferences(x)
      while (i < px.length && px(i) != y) {
        val u = px(i)
        val v = pairMap(u)
        val pu = preferences(u)
        val xorder = pu.indexOf(x)
        val vorder = pu.indexOf(v)
        if (xorder < vorder) ans.addOne(x)
        i += 1
      }
    }
    ans.size
  }
}
