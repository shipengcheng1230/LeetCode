// https://leetcode.com/problems/delete-nodes-and-return-forest/
object lt1110 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
    }

  def delNodes(root: TreeNode, to_delete: Array[Int]): List[TreeNode] = {
    val ret = scala.collection.mutable.ListBuffer.empty[TreeNode]
    val toDelete = to_delete.toSet

    def walk(root: TreeNode, isNew: Boolean): TreeNode = {
      if (root != null) {
        if (toDelete.contains(root.value)) {
          walk(root.left, true)
          walk(root.right, true)
          null
        } else {
          if (isNew) ret.append(root)
          root.left = walk(root.left, false)
          root.right = walk(root.right, false)
          root
        }
      } else null
    }

    walk(root, true)
    ret.toList
  }
}
