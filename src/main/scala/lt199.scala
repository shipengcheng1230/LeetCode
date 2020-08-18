// https://leetcode.com/problems/binary-tree-right-side-view/
object lt199 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
     var value: Int = _value
     var left: TreeNode = _left
     var right: TreeNode = _right
  }

  def rightSideView(root: TreeNode): List[Int] = {
    val ans = scala.collection.mutable.ListBuffer.empty[Int]

    def dfs(root: TreeNode, level: Int): Unit = {
      if (level == ans.size) ans.append(root.value)
      if (root.right != null) dfs(root.right, level + 1)
      if (root.left != null) dfs(root.left, level + 1)
    }

    dfs(root, 0)
    ans.toList
  }
}
