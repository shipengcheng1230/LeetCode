// https://leetcode.com/problems/largest-bst-subtree/
object lt333 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def largestBSTSubtree(root: TreeNode): Int = {

    def helper(node: TreeNode): Vector[Int] = {
      if (node == null) Vector(Int.MaxValue, Int.MinValue, 0)
      else {
        val left = helper(node.left)
        val right = helper(node.right)
        if (node.value > left(1) && node.value < right(0))
          Vector(node.value min left(0), node.value max right(1), left(2) + right(2) + 1)
        else
          Vector(Int.MinValue, Int.MaxValue, left(2) max right(2))
      }
    }

    helper(root)(2)
  }
}
