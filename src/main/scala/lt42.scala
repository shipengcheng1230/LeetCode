import scala.annotation.tailrec

object lt42 {
  def trap(height: Array[Int]): Int = {

    var leftMax = 0
    var rightMax = 0
    var ans = 0

    @tailrec
    def iterate(left: Int, right: Int): Int = {
      if (left >= right) ans
      else {
        if (height(left) < height(right)) {
          if (height(left) >= leftMax) leftMax = height(left)
          else ans += leftMax - height(left)
          iterate(left+1, right)
        }
        else {
          if (height(right) >= rightMax) rightMax = height(right)
          else ans += rightMax - height(right)
          iterate(left, right-1)
        }
      }
    }

    iterate(0, height.length-1)
  }
}