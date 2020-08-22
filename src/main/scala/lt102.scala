// https://leetcode.com/problems/binary-tree-level-order-traversal/
object lt102 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def levelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) return List(List())

    import scala.collection.mutable
    val ans = mutable.ListBuffer.empty[List[Int]]
    val q = mutable.Queue.empty[TreeNode]
    q.enqueue(root)
    while (q.nonEmpty) {
      val res = mutable.ListBuffer.empty[Int]
      q.dequeueAll(_ => true).foreach(p => {
        res.append(p.value)
        if (p.left != null) q.enqueue(p.left)
        if (p.right != null) q.enqueue(p.right)
      })
      ans.append(res.toList)
    }
    ans.toList
  }
}
