// https://leetcode.com/problems/delete-node-in-a-bst/
object lt450 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def deleteNode(root: TreeNode, key: Int): TreeNode = {

    def successor(root: TreeNode): Int = {
      var curr = root.right
      while (curr.left != null) curr = curr.left
      curr.value
    }

    def predecessor(root: TreeNode): Int = {
      var curr = root.left
      while (curr.right != null) curr = curr.right
      curr.value
    }

    if (root == null) return null
    if (key > root.value) root.right = deleteNode(root.right, key)
    else if (key < root.value) root.left = deleteNode(root.left, key)
    else {
      if (root.left == null && root.right == null) return null
      else if (root.right != null) {
        root.value = successor(root)
        root.right = deleteNode(root.right, root.value)
      } else {
        root.value = predecessor(root)
        root.left = deleteNode(root.left, root.value)
      }
    }
    root
  }
}
