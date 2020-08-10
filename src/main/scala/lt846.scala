// https://leetcode.com/problems/hand-of-straights/
object lt846 {
  def isNStraightHand(hand: Array[Int], W: Int): Boolean = {
    import scala.collection.mutable

    val count = hand.groupMapReduce(identity)(_ => 1)(_ + _).to(mutable.TreeMap)
    while (count.nonEmpty) {
      val first = count.head._1
      (first until W + first).foreach(card => {
        if (count.contains(card)) {
          val c = count(card)
          if (c == 1) count.remove(card)
          else count.update(card, count(card) - 1)
        } else return false
      })
    }
    true
  }

  def main(args: Array[String]): Unit = {
    println(isNStraightHand(Array(1,2,3,6,2,3,4,7,8), 3))
  }
}
