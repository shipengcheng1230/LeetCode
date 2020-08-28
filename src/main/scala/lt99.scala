// https://leetcode.com/problems/recover-binary-search-tree/
object lt99 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def recoverTree(root: TreeNode): Unit = {
    var prev: TreeNode = null
    var x: TreeNode = null
    var y: TreeNode = null

    def inorder(root: TreeNode): Unit = {
      if (root == null) return
      inorder(root.left)
      if (prev != null && root.value < prev.value) {
        y = root
        if (x == null) x = prev
        else return
      }
      prev = root
      inorder(root.right)
    }

    inorder(root)
    val tmp = x.value
    x.value = y.value
    y.value = tmp
  }
}
