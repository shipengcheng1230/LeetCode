// https://leetcode.com/problems/validate-binary-search-tree/
object lt98 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def isValidBST(root: TreeNode): Boolean = {

    def helper(node: TreeNode, lower: Int, upper: Int): Boolean = {
      if (node == null) true
      else if (node.value < lower && node.value > upper) false
      else helper(node.left, lower, node.value) && helper(node.right, node.value, upper)
    }
    helper(root, Int.MinValue, Int.MaxValue)
  }
}
