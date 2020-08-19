
// https://leetcode.com/problems/sort-list/
object lt148 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def sortList(head: ListNode): ListNode = {
    import scala.annotation.tailrec

    @tailrec
    def length(node: ListNode, count: Int = 0): Int =
      if (node == null) count else length(node.next, count + 1)

    @tailrec
    def split(node: ListNode, step: Int = 1): ListNode = {
      if (node == null) node else {
        if (node.next == null || step == 1) {
          val right = node.next
          node.next = null
          right
        } else split(node.next, step - 1)
      }
    }

    @tailrec
    def merge(left: ListNode, right: ListNode, prev: ListNode): ListNode = {
      if (left == null && right == null)
        prev
      else if (left == null) {
        prev.next = right
        merge(left, right.next, prev.next)
      }
      else if (right == null) {
        prev.next = left
        merge(left.next, right, prev.next)
      }
      else {
        if (left.x < right.x) {
          prev.next = left
          merge(left.next, right, prev.next)
        } else {
          prev.next = right
          merge(left, right.next, prev.next)
        }
      }
    }

    val n = length(head)
    var step = 1
    val dummy = new ListNode(0, head)

    while (step < n) {
      var prev = dummy
      var cur = dummy.next
      while (cur != null) {
        val left = cur
        val right = split(left, step)
        cur = split(right, step)
        prev = merge(left, right, prev)
      }
      step <<= 1
    }
    dummy.next
  }
}
