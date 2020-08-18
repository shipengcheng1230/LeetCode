
// https://leetcode.com/problems/happy-number/
object lt202 {
  def isHappy(n: Int): Boolean = {
    import scala.annotation.tailrec

    @tailrec
    def helper(n: Int, set: Set[Int]): Boolean = {
      if (n == 1) true
      else if (set.contains(n)) false
      else helper(sumSquare(n, 0), set.incl(n))
    }

    @tailrec
    def sumSquare(n: Int, ans: Int): Int = {
      if (n == 0) ans else {
        val (a, b) = (n / 10, n % 10)
        sumSquare(a, ans + b * b)
      }
    }

    helper(n, Set.empty[Int])
  }
}
