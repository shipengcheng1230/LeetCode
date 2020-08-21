// https://leetcode.com/problems/powx-n/
object lt50 {
  def myPow(x: Double, n: Int): Double = {

    def helper(x: Double, n: Int): Double = {
      if (n < 0) 1 / helper(x, -n)
      else if (n == 0) 1
      else {
        val y = helper(x, n / 2)
        val y2 = y * y
        if (n % 2 == 0) y2
        else x * y2
      }
    }

    helper(x, n)
  }
}
