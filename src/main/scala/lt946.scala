// https://leetcode.com/problems/validate-stack-sequences/
object lt946 {
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    val stack = scala.collection.mutable.Stack.empty[Int]
    var j = 0
    pushed.foreach(x => {
      stack.push(x)
      while (stack.nonEmpty && j < popped.length && stack.head == popped(j)) {
        stack.pop()
        j += 1
      }
    })
    stack.isEmpty
  }
}
