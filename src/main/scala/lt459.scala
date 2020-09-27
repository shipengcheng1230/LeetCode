// https://leetcode.com/submissions/detail/400374302/
object lt459 {
  import scala.annotation.tailrec

  def repeatedSubstringPattern(s: String): Boolean = {
    val count = s.groupMapReduce(identity)(_ => 1)(_ + _)
    val m = count.values.reduce(gcd)
    if (m == 1) false
    else {
      val c = count.values.map(_ / m).sum
      for (i <- 1 until m) {
        if (s.substring(0, c * i) * (s.length / c / i) == s)
          return true
      }
      false
    }
  }

  @tailrec
  def gcd(x: Int, y: Int): Int = {
    if (y == 0) x else gcd(y, x % y)
  }

  def repeatedSubstringPattern2(s: String): Boolean = {
    val n = s.length
    if (n < 2) false
    else if (n == 2) s(0) == s(1)
    else {
      for (i <- math.sqrt(n).round.toInt to 1 by -1; if n % i == 0) {
        val divisors = if (i == 1) List(i) else List(i, n / i)
        for (l <- divisors) {
          var tmp = s.substring(0, l)
          val firstHash = tmp.hashCode
          var currHash = firstHash
          var start = l
          while (start != n && currHash == firstHash) {
            tmp = s.substring(start, start + l)
            currHash = tmp.hashCode
            start += l
          }
          if (start == n && currHash == firstHash) return true
        }
      }
      false
    }
  }
}
