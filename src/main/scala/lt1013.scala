// https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
object lt1013 {
  def maxSumTwoNoOverlap(A: Array[Int], L: Int, M: Int): Int = {
    if (A.isEmpty) return 0
    val prefix = A.scanLeft(0)(_ + _)
    var lmax = prefix(L)
    var mmax = prefix(M)
    var res = prefix(L + M)
    for (i <- L + M to A.length) {
      lmax = lmax max (prefix(i - M) - prefix(i - M - L))
      mmax = mmax max (prefix(i - L) - prefix(i - M - L))
      res = res max ((lmax + prefix(i) - prefix(i - M)) max (mmax + prefix(i) - prefix(i - L)))
    }
    res
  }
}
