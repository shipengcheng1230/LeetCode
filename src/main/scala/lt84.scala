// https://leetcode.com/problems/largest-rectangle-in-histogram/
object lt84 {
  def largestRectangleArea(heights: Array[Int]): Int = {
    val stack = scala.collection.mutable.Stack.empty[Int]
    var ans = 0
    stack.push(-1) // dummy index to count horizontal distance
    heights.indices.foreach(i => {
      while (stack.head != -1 && heights(stack.head) >= heights(i)) {
        val x = stack.pop()
        ans = ans max (heights(x) * (i - stack.head - 1))
      }
      stack.push(i)
    })
    while (stack.head != -1) {
      val x = stack.pop()
      ans = ans max (heights(x) * (heights.length - stack.head - 1))
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    print(largestRectangleArea(Array(2,1,5,6,2,3)))
  }
}
