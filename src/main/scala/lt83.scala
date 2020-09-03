// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
object lt83 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def deleteDuplicates(head: ListNode): ListNode = {
    var curr = head
    while (curr != null && curr.next != null) {
      if (curr.next.x == curr.x)
        curr.next = curr.next.next
      else
        curr = curr.next
    }
    head
  }
}
