// https://leetcode.com/problems/count-primes/
object lt204 {
  def countPrimes(n: Int): Int = {
    val d = Array.fill(n)(true)
    var i = 2
    while (i * i < n) {
      if (d(i)) {
        (i * i until n by i).foreach(j => d(j) = false)
      }
      i += 1
    }
    d.slice(2, d.length).count(_ == true)
  }
}
