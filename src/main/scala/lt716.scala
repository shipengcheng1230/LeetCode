// https://leetcode.com/problems/max-stack/
object lt716 {

  class MaxStack() {

    import scala.collection.mutable

    val stack: mutable.Stack[Int] = mutable.Stack.empty[Int]
    val maxStack: mutable.Stack[Int] = mutable.Stack.empty[Int]

    def push(x: Int): Unit = {
      val max = if (maxStack.isEmpty) x else maxStack.head
      maxStack.push(if (x > max) x else max)
      stack.push(x)
    }

    def pop(): Int = {
      maxStack.pop()
      stack.pop()
    }

    def top(): Int = {
      stack.head
    }

    def peekMax(): Int = {
      maxStack.head
    }

    def popMax(): Int = {
      val max = maxStack.head
      val buffer = mutable.Stack.empty[Int]
      while (top() != max) buffer.push(pop())
      pop()
      while (buffer.nonEmpty) push((buffer.pop()))
      max
    }

  }

}
