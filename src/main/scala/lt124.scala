// https://leetcode.com/problems/binary-tree-maximum-path-sum/
object lt124 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
   }

  def maxPathSum(root: TreeNode): Int = {
    var ans = Integer.MIN_VALUE

    def maxGain(node: TreeNode): Int = {
      if (node == null) 0
      else {
        val left = maxGain(node.left) max 0
        val right = maxGain(node.right) max 0
        ans = ans max (node.value + left + right)
        node.value + (left max right)
      }
    }

    maxGain(root)
  }
}
