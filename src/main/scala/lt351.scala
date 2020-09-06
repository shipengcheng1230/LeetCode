// https://leetcode.com/problems/android-unlock-patterns/
object lt351 {
  def numberOfPatterns(m: Int, n: Int): Int = {
    val used = Array.fill(9)(false)

    def isValid(index: Int, last: Int): Boolean = {
      if (used(index)) return false
      if (last == -1) return true
      if ((index + last) % 2 == 1) return true
      val mid = (index + last) / 2
      if (mid == 4) return used(mid)
      if ((index % 3 != last % 3) && (index / 3 != last / 3)) return true
      used(mid)
    }

    def calcPatterns(last: Int, len: Int): Int = {
      if (len == 0) 1
      else {
        var sum = 0
        (0 until 9).foreach(i => {
          if (isValid(i, last)) {
            used(i) = true
            sum += calcPatterns(i, len - 1)
            used(i) = false
          }
        })
        sum
      }
    }

    var res = 0
    (m to n).foreach(i => {
      res += calcPatterns(-1, i)
      used.indices.foreach(i => used(i) = false)
    })
    res
  }
}
