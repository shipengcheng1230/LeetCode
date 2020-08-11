// https://leetcode.com/problems/flip-equivalent-binary-trees/solution/
object lt951 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def flipEquiv(root1: TreeNode, root2: TreeNode): Boolean = {
    if (root1 == root2) true
    else if (root1 == null || root2 == null || root1.value != root2.value) false
    else {
      (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
        (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
    }
  }
}
