// https://leetcode.com/problems/palindrome-partitioning/
object lt131 {
  def partition(s: String): List[List[String]] = {

    def helper(cut: Int): List[List[String]] = {
      if (cut >= s.length) List(List())
      else {
        for {
          e <- cut + 1 to s.length
          sub = s.substring(cut, e)
          if sub == sub.reverse
          rs <- helper(e)
        } yield sub :: rs
      }.toList
    }

    helper(0)
  }
}
