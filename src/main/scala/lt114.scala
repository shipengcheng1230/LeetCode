// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
object lt114 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def flatten(root: TreeNode): Unit = {

    def flattenTree(node: TreeNode): TreeNode = {
      if (node == null || node.left == null && node.right == null) return node

      val leftTail = flattenTree(node.left)
      val rightTail = flattenTree(node.right)
      if (leftTail != null) {
        leftTail.right = node.right
        node.right = node.left
        node.left = null
      }
      if (rightTail == null) leftTail else rightTail
    }

    flattenTree(root)
  }

  def flatten2(root: TreeNode): Unit = {
    if (root != null) {
      var curr = root
      while (curr != null) {
        if (curr.left != null) {
          var rightMost= curr.left
          while (rightMost.right != null) {
            rightMost = rightMost.right
          }
          rightMost.right = curr.right
          curr.right = curr.left
          curr.left = null
        }
        curr = curr.right
      }
    }
  }
}
