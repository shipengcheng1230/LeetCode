// https://leetcode.com/problems/symmetric-tree/
object lt101 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def isSymmetric(root: TreeNode): Boolean = {

    import scala.collection.mutable
    val q = mutable.Queue.empty[TreeNode]
    q.enqueue(root)
    q.enqueue(root)
    while (q.nonEmpty) {
      val t1 = q.dequeue()
      val t2 = q.dequeue()
      if (!(t1 == null && t2 == null)) {
        if (t1 == null && t2 != null || t1 != null && t2 == null || t1.value != t2.value)
          return false

        q.enqueue(t1.left)
        q.enqueue(t2.right)
        q.enqueue(t1.right)
        q.enqueue(t2.left)
      }
    }
    true
  }
}
