// https://leetcode.com/problems/first-bad-version/
object lt278 {

  def isBadVersion(version: Int): Boolean = {???}

  def firstBadVersion(n: Int): Int = {
    var lo = 1
    var hi = n
    while (lo < hi) {
      val mid = lo + (hi - lo) / 2
      if (isBadVersion(mid))
        hi = mid
      else
        lo = mid + 1
    }
    lo
  }
}
