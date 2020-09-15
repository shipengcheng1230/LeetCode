// https://leetcode.com/problems/inorder-successor-in-bst/
object lt285 {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }

  def inorderSuccessor(root: TreeNode, p: TreeNode): TreeNode = {
    val stack = scala.collection.mutable.Stack.empty[TreeNode]
    var curr = root
    var prev = Int.MinValue
    while (curr != null || stack.nonEmpty) {
      while (curr != null) {
        stack.push(curr)
        curr = curr.left
      }
      curr = stack.pop()
      if (prev == p.value) return curr
      prev = curr.value
      curr = curr.right
    }
    null
  }
}
