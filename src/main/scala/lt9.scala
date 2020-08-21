// https://leetcode.com/problems/palindrome-number/
object lt9 {
  def isPalindrome(x: Int): Boolean = {
    val y = x.toString
    y == y.reverse
  }
}
