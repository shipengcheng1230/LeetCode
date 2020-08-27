// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
object lt109 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def sortedListToBST(head: ListNode): TreeNode = {
    var h = head

    def convertListToBST(l: Int, r: Int): TreeNode = {
      if (l > r) null
      else {
        val mid = (l + r) / 2
        val left = convertListToBST(l, mid - 1)
        val node = new TreeNode(h.x)
        node.left = left
        h = h.next
        node.right = convertListToBST(mid + 1, r)
        node
      }
    }

    val size = length(head)
    convertListToBST(0, size - 1)
  }

  @scala.annotation.tailrec
  def length(node: ListNode, count: Int = 0): Int =
    if (node == null) count else length(node.next, count + 1)

  def main(args: Array[String]): Unit = {
    val ns = Array(-10,-3,0,5,9).map(new ListNode(_, null))
    ns.sliding(2, 1).foreach(x => x(0).next = x(1))
    sortedListToBST(ns.head)
  }

}
