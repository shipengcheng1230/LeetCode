// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
object lt1296 {
  def isPossibleDivide(nums: Array[Int], k: Int): Boolean = {
    import scala.collection.mutable

    val count = nums.groupMapReduce(identity)(_ => 1)(_ + _).to(mutable.TreeMap)
    while (count.nonEmpty) {
      val first = count.head._1
      (0 until k).foreach(i => {
        count.get(first + i) match {
          case None => return false
          case Some(x) =>
            count.update(first + i, count(first + i) - 1)
            if (count(first + i) == 0) count.remove(first + i)
        }
      })
    }
    count.isEmpty
  }
}
