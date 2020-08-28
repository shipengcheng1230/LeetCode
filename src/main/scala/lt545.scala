// https://leetcode.com/problems/boundary-of-binary-tree/
object lt545 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def boundaryOfBinaryTree(root: TreeNode): List[Int] = {
    import scala.collection.mutable

    if (root == null) return Nil
    val ans = mutable.ListBuffer.empty[Int]

    def isLeaf(node: TreeNode): Boolean = node.left == null && node.right == null

    if (!isLeaf(root)) ans.addOne(root.value)
    var t = root.left
    while (t != null) {
      if (!isLeaf(t))
        ans.addOne(t.value)
      if (t.left != null)
        t = t.left
      else
        t = t.right
    }

    def addLeaves(root: TreeNode): Unit = {
      if (isLeaf(root))
        ans.addOne(root.value)
      else {
        if (root.left != null)
          addLeaves(root.left)
        if (root.right != null)
          addLeaves(root.right)
      }
    }

    addLeaves(root)

    val stack = mutable.Stack.empty[Int]
    t = root.right
    while (t != null) {
      if (!isLeaf(t))
        stack.push(t.value)
      if (t.right != null)
        t = t.right
      else
        t = t.left
    }

    ans.addAll(stack)
    ans.toList
  }
}
