// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
object lt230 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def kthSmallest(root: TreeNode, k: Int): Int = {
    import scala.collection.mutable.Stack

    val stack = Stack.empty[TreeNode]
    var count = 0
    var curr = root

    while (curr != null || stack.nonEmpty) {
      while (curr != null) {
        stack.push(curr)
        curr = curr.left
      }
      curr = stack.pop()
      count += 1
      if (count == k) return curr.value
      curr = curr.right
    }

    curr.value
  }
}
