// https://leetcode.com/problems/binary-search-tree-iterator/
object lt173 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  class BSTIterator(_root: TreeNode) {

    import scala.collection.mutable

    // use `stack` where we can pause/continue to simulate recursion stack
    val stack: mutable.Stack[TreeNode] = mutable.Stack.empty[TreeNode]
    leftMostInorder(_root)

    def leftMostInorder(node: TreeNode): Unit = {
      var cur = node
      while (cur != null) {
        stack.push(cur)
        cur = cur.left
      }
    }

    /** @return the next smallest number */
    def next(): Int = {
      val node = stack.pop()
      if (node.right != null) {
        leftMostInorder(node.right)
      }
      node.value
    }

    /** @return whether we have a next smallest number */
    def hasNext: Boolean = {
      stack.nonEmpty
    }

  }
}
