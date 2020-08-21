// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
object lt105 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    var pre = 0
    var in = 0

    def build(stop: Int): TreeNode = {
      if (pre >= preorder.length) null
      else {
        if (inorder(in) == stop) {
          in += 1
          null
        } else {
          val node = new TreeNode(preorder(pre))
          pre += 1
          node.left = build(node.value)
          node.right = build(stop)
          node
        }
      }
    }

    build(Int.MinValue)
  }
}

