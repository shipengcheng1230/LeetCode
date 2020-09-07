// https://leetcode.com/problems/ugly-number/
object lt263 {
  def isUgly(num: Int): Boolean = {
    var x = num
    for (i <- 2 to 5; if x > 0) {
      while (x % i ==0)
        x /= i
    }
    x == 1
  }
}
