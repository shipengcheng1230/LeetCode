//  https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/submissions/
object lt914 {

  import scala.annotation.tailrec

  def hasGroupsSizeX(deck: Array[Int]): Boolean = {
    val count = deck.groupMapReduce(identity)(_ => 1)(_ + _)
    count.values.reduce(gcd) > 1
  }

  @tailrec
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
}
