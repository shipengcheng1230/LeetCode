// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
object lt19 {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    val dummy = new ListNode(0, head)
    var first = dummy
    var second = dummy
    (0 to n).foreach(_ => first = first.next)
    while (first != null) {
      first = first.next
      second = second.next
    }
    second.next = second.next.next
    dummy.next
  }

}
