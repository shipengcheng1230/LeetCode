// https://leetcode.com/problems/valid-anagram/
object lt242 {
  def isAnagram(s: String, t: String): Boolean = {
    if (s.length != t.length) false
    else {
      val table = Array.fill(26)(0)
      s.foreach(c => table(c - 'a') += 1)
      t.foreach(c => {
        table(c - 'a') -= 1
        if (table(c - 'a') < 0)
          return false
      })
      true
    }
  }
}
