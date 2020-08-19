// https://leetcode.com/problems/flatten-nested-list-iterator/
object lt341 {

  class NestedInteger {
    // Return true if this NestedInteger holds a single integer, rather than a nested list.
    def isInteger: Boolean = {???}

    // Return the single integer that this NestedInteger holds, if it holds a single integer
    def getInteger: Int = {???}

    // Set this NestedInteger to hold a single integer.
    def setInteger(i: Int): Unit = {???}

    // Return the nested list that this NestedInteger holds, if it holds a nested list
    def getList: Array[NestedInteger] = {???}

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    def add(ni: NestedInteger): Unit = {???}
  }

  class NestedIterator(_nestedList: List[NestedInteger]) {

    import scala.collection.mutable.Stack

    var stack = Stack.empty[Iterator[NestedInteger]]
    var nextInt: Option[Int] = None
    stack.push(_nestedList.iterator)

    def hasNext: Boolean = {
      nextInt match {
        case Some(_) => true
        case None =>
          while (stack.nonEmpty) {
            if (!stack.head.hasNext) stack.pop()
            else {
              val next = stack.head.next()
              if (next.isInteger) {
                nextInt = Some(next.getInteger)
                return true
              }
              else stack.push(next.getList.iterator)
            }
          }
          false
      }
    }

    def next(): Int = {
      nextInt match {
        case Some(x) =>
          nextInt = None
          x
        case None => 0
      }
    }
  }
}
