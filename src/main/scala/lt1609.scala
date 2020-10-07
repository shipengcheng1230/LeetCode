// https://leetcode.com/problems/even-odd-tree/
object lt1609 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def isEvenOddTree(root: TreeNode): Boolean = {
    import scala.collection.mutable.Queue

    val q = Queue.empty[TreeNode].enqueue(root)
    var even = true
    while (q.nonEmpty) {
      var prev = if (even) Int.MinValue else Int.MaxValue
      q.dequeueAll(_ => true).foreach(node => {
        if (even) {
          if (node.value <= prev || node.value % 2 != 1) return false
          else prev = node.value
        } else {
          if (node.value >= prev || node.value % 2 != 0) return false
          else prev = node.value
        }

        if (node.left != null) q.enqueue(node.left)
        if (node.right != null) q.enqueue(node.right)
      })
      even = !even
    }
    true
  }
}
