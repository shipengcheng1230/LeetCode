// https://leetcode.com/problems/swap-nodes-in-pairs/
object lt24 {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def swapPairs(head: ListNode): ListNode = {
    if (head == null || head.next == null) head
    else {
      val dummy = new ListNode(-1, head)
      var prev = dummy
      var curr = head
      while (curr != null && curr.next != null) {
        val second = curr.next
        prev.next = second
        curr.next = second.next
        second.next = curr
        prev = curr
        curr = curr.next
      }
      dummy.next
    }
  }
}
