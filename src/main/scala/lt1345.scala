
// https://leetcode.com/problems/jump-game-iv/
object lt1345 {
//  def minJumps(arr: Array[Int]): Int = {
//    import scala.annotation.tailrec
//
//    val inv1 = arr.zipWithIndex.groupMap(_._1)(_._2).view.mapValues(_.toSet).toMap
//    val inv2 = arr.zipWithIndex.map(x => Set(x._2 - 1, x._2 + 1).filter(y => y >= 0 && y < arr.length).union(inv1(x._1).excl(x._2)))
//
//    @tailrec
//    def helper(curs: Set[Int], taken: Set[Int], count: Int): Int = {
//      if (curs.contains(arr.length - 1)) count else {
//        val next = curs.flatMap(inv2).removedAll(taken)
//        helper(next, taken.union(next), count + 1)
//      }
//    }
//
//    helper(Set(0), Set(0), 0)
//  }

  def minJumps(arr: Array[Int]): Int = {
    import scala.collection.mutable
    val n = arr.length
    val map = arr.zipWithIndex.groupMap(_._1)(_._2).view.mapValues(_.to(mutable.ListBuffer)).toMap
    val q = mutable.Queue.empty[Int]
    val visited = Array.fill(n)(false)
    q.enqueue(0)
    visited(0) = true
    var step = 0

    while (q.nonEmpty) {
      q.dequeueAll(_ => true).foreach(p => {
        if (p == n - 1) return step
        val next = map(arr(p))
        next.addOne(p - 1)
        next.addOne(p + 1)
        next.foreach(x => {
          if (x >= 0 && x < n && !visited(x)) {
            visited(x) = true
            q.enqueue(x)
          }
        })
        next.clear() // avoid back-look-up
      })
      step += 1
    }
    0
  }

  def main(args: Array[String]): Unit = {
    println(minJumps(Array(100,-23,-23,404,100,23,23,23,3,404)))
  }
}
