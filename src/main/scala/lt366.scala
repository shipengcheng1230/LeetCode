object lt366 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def findLeaves(root: TreeNode): List[List[Int]] = {
    import scala.collection.mutable
    val ans = mutable.Map.empty[Int, mutable.ListBuffer[Int]]

    def dfs(node: TreeNode): Int = {
      if (node == null) 0
      else {
        val z = 1 + (dfs(node.left) max dfs(node.right))
        ans.getOrElseUpdate(z, mutable.ListBuffer.empty[Int]).append(node.value)
        z
      }
    }

    dfs(root)
    ans.toSeq.sortBy(_._1).map(_._2.toList).toList
  }
}
