// https://leetcode.com/problems/container-with-most-water/
object lt11 {
  def maxArea(height: Array[Int]): Int = {
    var i = 0
    var j = height.length - 1
    var maxarea = Integer.MIN_VALUE
    while (i < j) {
      maxarea = maxarea max ((j - i) * (height(i) min height(j)))
      if (height(i) < height(j)) i += 1 else j -= 1
    }
    maxarea
  }
}
