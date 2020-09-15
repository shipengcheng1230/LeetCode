// https://leetcode.com/problems/closest-binary-search-tree-value/
object lt270 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def closestValue(root: TreeNode, target: Double): Int = {
    var ans = 0
    var minDiff = Double.MaxValue

    def dfs(root: TreeNode): Unit = {
      if (root != null) {
        val diff = root.value - target
        if (math.abs(diff) < minDiff) {
          ans = root.value
          minDiff = math.abs(diff)
        }
        if (diff < 0 && root.right != null) dfs(root.right)
        if (diff > 0 && root.left != null) dfs(root.left)
      }
    }

    dfs(root)
    ans
  }
}
