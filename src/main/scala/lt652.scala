object lt652 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def findDuplicateSubtrees(root: TreeNode): List[TreeNode] = {
    val map = scala.collection.mutable.Map.empty[String, List[TreeNode]]

    def trv(node: TreeNode): String = {
      if (node == null) "null"
      else {
        val struct = s"${node.value},${trv(node.left)},${trv(node.right)}"
        map.update(struct, node :: map.getOrElse(struct, List.empty[TreeNode]))
        struct
      }
    }

    trv(root)
    map.toSeq.filter(x => x._2.length > 1).map(_._2.head).toList
  }
}
