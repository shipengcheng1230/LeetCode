// https://leetcode.com/problems/remove-linked-list-elements/
object lt203 {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def removeElements(head: ListNode, `val`: Int): ListNode = {
    if (head == null) head
    else if (head.x == `val`) removeElements(head.next, `val`)
    else {
      val next = removeElements(head.next, `val`)
      head.next = next
      head
    }
  }
}
