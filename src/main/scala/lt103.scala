// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
object lt103 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    import scala.collection.mutable

    if (root == null) Nil
    else {
      val ans = mutable.ListBuffer.empty[List[Int]]
      val store = mutable.ArrayDeque.empty[Int]
      val q = mutable.Queue.empty[TreeNode]
      q.enqueue(root)
      var level = true
      while (q.nonEmpty) {
        store.clear()
        q.dequeueAll(_ => true).foreach(p => {
          if (level) store.append(p.value)
          else store.prepend(p.value)
          if (p.left != null) q.enqueue(p.left)
          if (p.right != null) q.enqueue(p.right)
        })
        ans.addOne(store.toList)
        level = !level
      }
      ans.toList
    }
  }
}
