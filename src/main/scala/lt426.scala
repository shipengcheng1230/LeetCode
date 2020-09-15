// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
object lt426 {

  class Node(var _value: Int) {
    var value: Int = _value
    var left: Node = _
    var right: Node = _
  }

  def treeToDoublyList(root: Node): Node = {
    if (root == null) return null

    var first: Node = null
    var last: Node = null

    def inorder(node: Node): Unit = {
      if (node != null) {
        inorder(node.left)
        if (last != null) {
          last.right = node
          node.left = last
        } else {
          first = node
        }
        last = node
        inorder(node.right)
      }
    }

    inorder(root)
    last.right = first
    first.left = last
    first
  }

  def treeToDoublyList2(root: Node): Node = {
    if (root == null) null else {
      val dummy = new Node(0)
      var prev = dummy
      val stack = scala.collection.mutable.Stack.empty[Node]
      var curr = root

      while (stack.nonEmpty || curr != null) {
        while (curr != null) {
          stack.push(curr)
          curr = curr.left
        }
        curr = stack.pop()
        prev.right = curr
        curr.left = prev
        prev = curr
        curr = curr.right
      }

      dummy.right.left = prev
      prev.right = dummy.right
      dummy.right
    }
  }
}
