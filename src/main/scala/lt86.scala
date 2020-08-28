// https://leetcode.com/problems/partition-list/
object lt86 {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def partition(head: ListNode, x: Int): ListNode = {
    val small = new ListNode(0)
    val large = new ListNode(0)
    var c1 = small
    var c2 = large
    var c = head
    while (c != null) {
      if (c.x < x) {
        c1.next = c
        c1 = c1.next
      } else {
        c2.next = c
        c2 = c2.next
      }
      c = c.next
    }
    c2.next = null
    c1.next = large.next
    small.next
  }
}
