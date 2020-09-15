// https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
object lt742 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def findClosestLeaf(root: TreeNode, k: Int): Int = {
    import scala.collection.mutable

    val map = mutable.Map.empty[TreeNode, TreeNode]
    val q = mutable.Queue.empty[TreeNode]
    val seen = mutable.Set.empty[TreeNode]

    def dfs(node: TreeNode): TreeNode = {
      if (node.value == k) node
      else {
        if (node.left != null) {
          map.update(node.left, node)
          val left = dfs(node.left)
          if (left != null) return left
        }
        if (node.right != null) {
          map.update(node.right, node)
          val right = dfs(node.right)
          if (right != null) return right
        }
        null
      }
    }

    val kNode = dfs(root)
    q.enqueue(kNode)
    seen.addOne(kNode)

    while (q.nonEmpty) {
      val curr = q.dequeue()
      if (curr.left == null && curr.right == null) return curr.value
      if (curr.left != null && seen.add(curr.left)) q.enqueue(curr.left)
      if (curr.right != null && seen.add(curr.right)) q.enqueue(curr.right)
      if (map.contains(curr) && seen.add(map(curr))) q.enqueue(map(curr))
    }
    -1
  }
}
