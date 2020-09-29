// https://leetcode.com/problems/height-checker/
object lt1051 {
  def heightChecker(heights: Array[Int]): Int = {
    // counting sort
    val freq = Array.fill(101)(0)
    heights.foreach(h => freq(h) += 1)
    var curr = 0
    var ans = 0
    heights.foreach(h => {
      while (freq(curr) == 0) curr += 1
      if (h != curr) ans += 1
      freq(curr) -= 1
    })
    ans
  }
}
