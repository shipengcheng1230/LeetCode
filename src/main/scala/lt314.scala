// https://leetcode.com/problems/binary-tree-vertical-order-traversal/
object lt314 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def verticalOrder(root: TreeNode): List[List[Int]] = {
    import scala.collection.mutable
    val map = mutable.Map.empty[Int, mutable.ArrayBuffer[Int]]
    val q = mutable.Queue.empty[(TreeNode, Int)]
    q.enqueue((root, 0))
    while (q.nonEmpty) {
      val (root, col) = q.dequeue()
      if (root != null) {
        if (!map.contains(col))
          map.update(col, mutable.ArrayBuffer.empty[Int])

        map(col).append(root.value)
        q.enqueue((root.left, col - 1))
        q.enqueue((root.right, col + 1))
      }
    }
    map.toSeq.sortBy(_._1).map(_._2.toList).toList
  }
}
