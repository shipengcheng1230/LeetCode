// https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/
object lt431 {

  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }


  class Codec {

    import scala.collection.mutable.Queue

    // Encodes an n-ary tree to a binary tree.
    def encode(root: Node): TreeNode = {
      if (root == null) null
      else {
        val rootTreeNode = new TreeNode(root.value)
        val q = Queue.empty[(Node, TreeNode)]
        q.enqueue((root, rootTreeNode))
        while (q.nonEmpty) {
          val (curr, parent) = q.dequeue()
          var prev: TreeNode = null
          var head: TreeNode = null
          curr.children.foreach(child => {
            val childTreeNode = new TreeNode(child.value)
            if (head == null) head = childTreeNode
            if (prev != null) prev.right = childTreeNode
            prev = childTreeNode
            q.enqueue((child, childTreeNode))
          })
          parent.left = head
        }
        rootTreeNode
      }
    }

    // Decodes your binary tree to an n-ary tree.
    def decode(root: TreeNode): Node = {
      if (root == null) null
      else {
        val rootNode = new Node(root.value)
        val q = Queue.empty[(Node, TreeNode)]
        q.enqueue((rootNode, root))
        while (q.nonEmpty) {
          val (parent, curr) = q.dequeue()
          val firstChild = curr.left
          var sibling = firstChild
          while (sibling != null) {
            val n = new Node(sibling.value)
            parent.children = parent.children.appended(n)
            q.enqueue((n, sibling))
            sibling = sibling.right
          }
        }
        rootNode
      }
    }

    def encode2(root: Node): TreeNode = {
      if (root == null) null
      else {
        val rootTreeNode = new TreeNode(root.value)
        if (root.children.nonEmpty) {
          rootTreeNode.left = encode(root.children.head)
          var curr = rootTreeNode.left
          root.children.tail.foreach(child => {
            curr.right = encode(child)
            curr = curr.right
          })
        }
        rootTreeNode
      }
    }

    // Decodes your binary tree to an n-ary tree.
    def decode2(root: TreeNode): Node = {
      if (root == null) null
      else {
        val rootNode = new Node(root.value)
        var curr = root.left
        while (curr != null) {
          rootNode.children = rootNode.children.appended(decode(curr))
          curr = curr.right
        }
        rootNode
      }
    }
  }
}
