// https://leetcode.com/problems/scramble-string/
object lt87 {
  def isScramble(s1: String, s2: String): Boolean = {
    if (s1 == s2) true
    else {
      val count = Array.fill(26)(0)
      s1.indices.foreach(i => {
        count(s1(i) - 'a') += 1
        count(s2(i) - 'a') -= 1
      })
      if (count.exists(_ != 0)) return false
      s1.indices.tail.foreach(i => {
        if (isScramble(s1.substring(0, i), s2.substring(0, i))
          && isScramble(s1.substring(i), s2.substring(i)))
          return true

        if (isScramble(s1.substring(0, i), s2.takeRight(i))
          && isScramble(s1.substring(i), s2.substring(0, s2.length - i)))
          return true
      })
      false
    }
  }
}
