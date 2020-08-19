// https://leetcode.com/problems/diameter-of-binary-tree/
object lt543 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def diameterOfBinaryTree(root: TreeNode): Int = {
    var ans = Integer.MIN_VALUE

    def maxDiameter(node: TreeNode): Int = {
      if (node == null) 0
      else {
        val left = maxDiameter(node.left)
        val right = maxDiameter(node.right)
        ans = ans max (left + right + 1)
        1 + (left max right)
      }
    }

    if (root == null) 0 else {
      maxDiameter(root)
      ans - 1
    }
  }
}
