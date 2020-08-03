import scala.annotation.tailrec

object lt2 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val s = new ListNode(0)

    @tailrec
    def helper(curr: ListNode, carry: Int, l1: ListNode, l2: ListNode): ListNode =      {
      val isl1end = l1 == null
      val isl2end = l2 == null

      if (isl1end && isl2end) {
        if (carry > 0) {curr.next = new ListNode(carry); s.next}
        else s.next
      }
      else {
        val x = if (isl1end) 0 else l1.x
        val y = if (isl2end) 0 else l2.x
        val sum = x + y + carry
        curr.next = new ListNode(sum % 10)
        val l1_ = if (isl1end) l1 else l1.next
        val l2_ = if (isl2end) l2 else l2.next
        helper(curr.next, sum / 10, l1_, l2_)
      }
    }

    helper(s, 0, l1, l2)
  }
}