object lt938 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def rangeSumBST(root: TreeNode, L: Int, R: Int): Int = {
    var sum = 0

    def dfs(node: TreeNode): Unit = {
      if (node != null) {
        if (node.value >= L && node.value <= R) {
          sum += node.value
          dfs(node.left)
          dfs(node.right)
        } else if (node.value < L) dfs(node.right)
        else dfs(node.left)
      }
    }

    dfs(root)
    sum
  }
}
