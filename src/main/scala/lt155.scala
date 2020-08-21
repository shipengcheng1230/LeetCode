// https://leetcode.com/problems/min-stack/
object lt155 {
  class MinStack() {
    import scala.collection.mutable

    val stack: mutable.Stack[(Int, Int)] = mutable.Stack.empty[(Int, Int)]

    def push(x: Int): Unit = {
      stack.headOption match {
        case None => stack.push((x, x))
        case Some(c) => stack.push((x, c._2 min x))
      }
    }

    def pop(): Unit = {
      stack.pop()
    }

    def top(): Int = {
      stack.head._1
    }

    def getMin: Int = {
      stack.head._2
    }

  }
}
