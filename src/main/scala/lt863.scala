object lt863 {

  import scala.collection.mutable

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }

  def distanceK(root: TreeNode, target: TreeNode, K: Int): List[Int] = {
    val res = mutable.ListBuffer.empty[Int]
    val map = mutable.HashMap.empty[TreeNode, Int]

    def find(node: TreeNode): Int = {
      if (node == null) return -1
      if (node == target) {
        map.update(node, 0)
        return 0
      }
      val left = find(node.left)
      if (left >= 0) {
        map.update(node, left + 1)
        return left + 1
      }
      val right = find(node.right)
      if (right >= 0) {
        map.update(node, right + 1)
        return right + 1
      }
      -1
    }

    def dfs(node: TreeNode, d: Int): Unit = {
      if (node != null) {
        val dist = map.getOrElse(node, d)
        if (dist == K) res.append(node.value)
        dfs(node.left, dist + 1)
        dfs(node.right, dist + 1)
      }
    }

    find(root)
    dfs(root, map(root))
    res.toList
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(3)
    root.left = new TreeNode(5)
    root.right = new TreeNode(1)
    root.left.left = new TreeNode(6)
    root.left.right = new TreeNode(2)
    root.left.right.left = new TreeNode(7)
    root.left.right.right = new TreeNode(4)
    root.right = new TreeNode(1)
    root.right.left = new TreeNode(0)
    root.right.right = new TreeNode(8)
    print(distanceK(root, root.left, 2))
  }
}
