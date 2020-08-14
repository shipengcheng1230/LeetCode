// https://leetcode.com/problems/house-robber-iii/
object lt337 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def rob(root: TreeNode): Int = {

    def dfs(node: TreeNode, canTake: Boolean): Int = {
      if (node != null) {
        if (canTake) {
          (node.value + dfs(node.left, false) + dfs(node.right, false))
            .max(dfs(node.left, true) + dfs(node.right, true))
        } else {
          dfs(node.left, true) + dfs(node.right, true)
        }
      } else 0
    }

    dfs(root, true)
  }
}
