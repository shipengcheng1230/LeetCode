// https://leetcode.com/problems/valid-palindrome-ii/
object lt680 {
  def validPalindrome(s: String): Boolean = {

    def isPalindrome(s: String, i: Int, j: Int): Boolean = {
      (i to (i + (j - i) / 2)).foreach(x => {
        if (s(x) != s(j - x + i)) return false
      })
      true
    }

    (0 until s.length).foreach(i => {
      val j = s.length - i - 1
      if (s(i) != s(j)) {
        return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1)
      }
    })
    true
  }
}
