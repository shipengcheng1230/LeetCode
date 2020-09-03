// https://leetcode.com/problems/maximum-depth-of-binary-tree/
object lt104 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def maxDepth(root: TreeNode): Int = {
    if (root == null) 0
    else {
      (maxDepth(root.left) max maxDepth(root.right)) + 1
    }
  }
}
