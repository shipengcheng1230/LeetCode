
// https://leetcode.com/problems/reverse-linked-list/
object lt206 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def reverseList(head: ListNode): ListNode = {
    import scala.annotation.tailrec

    @tailrec
    def helper(list: ListNode, prev: ListNode): ListNode = {
      list match {
        case cur: ListNode =>
          val next = cur.next
          cur.next = prev
          helper(next, cur)
        case _ => prev
      }
    }

    helper(head, null)
  }
}
