// https://leetcode.com/problems/count-univalue-subtrees/
object lt250 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def countUnivalSubtrees(root: TreeNode): Int = {
    var ans = 0

    def helper(node: TreeNode, value: Int): Boolean = {
      if (node == null) true
      // need to traverse both children, use `|` which is strict, while `||` is short circuit
      else if (!helper(node.left, node.value) | !helper(node.right, node.value)) false
      else {
        ans += 1
        node.value == value
      }
    }

    helper(root, 0)
    ans
  }
}
