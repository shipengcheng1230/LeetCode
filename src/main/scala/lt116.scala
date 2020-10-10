// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
object lt116 {

  class Node(var _value: Int) {
    var value: Int = _value
    var left: Node = _
    var right: Node = _
    var next: Node = _
  }

  def connect(root: Node): Node = {
    if (root == null) null
    else {
      var leftMost = root
      while (leftMost.left != null) {
        var head = leftMost
        while (head != null) {
          head.left.next = head.right
          if (head.next != null) {
            head.right.next = head.next.left
          }
          head = head.next
        }
        leftMost = leftMost.left
      }
    }
    root
  }
}
