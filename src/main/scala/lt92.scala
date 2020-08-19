// https://leetcode.com/problems/reverse-linked-list-ii/
object lt92 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def reverseBetween(head: ListNode, m: Int, n: Int): ListNode = {
    if (head == null || head.next == null) head else {
      val dummy = new ListNode(0, head)
      var prev = dummy
      var p = head
      (1 until m).foreach(_ => { prev = p; p = p.next })
      if (p == null) head else {
        var p1 = p.next
        var p2: ListNode = null
        (m until n).takeWhile(_ => p1 != null).foreach(_ => {
          p2 = p1.next
          p1.next = p
          p = p1
          p1 = p2
        })
        prev.next.next = p1
        prev.next = p
        dummy.next
      }
    }
  }
}
