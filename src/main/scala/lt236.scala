object lt236 {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }

  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {

    def dfs(node: TreeNode): TreeNode = {
      if (node == null) node
      else {
        if (node == p || node == q) node
        else {
          val l = dfs(node.left)
          val r = dfs(node.right)
          if (l != null && r != null) node
          else if (l == null) r
          else l
        }
      }
    }

    dfs(root)
  }
}
