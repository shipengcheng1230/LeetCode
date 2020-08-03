import scala.annotation.tailrec

object l23 {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def mergeKLists(lists: Array[ListNode]): ListNode = {
    if (lists.length == 0) return null
    var interval = 1
    while (interval < lists.length) {
      for (i <- 0 until (lists.length - interval) by interval * 2) {
        lists(i) = mergeTwoLists(lists(i), lists(i + interval))
      }
      interval *= 2
    }
    lists(0)
  }

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    val s = new ListNode(-1)

    @tailrec
    def iterate(l: ListNode, l1: ListNode, l2: ListNode): ListNode = {
      if (l1 == null) {l.next = l2; s.next}
      else {
        if (l2 == null) {l.next = l1; s.next}
        else {
          if (l1.x < l2.x) {l.next = l1; iterate(l.next, l1.next, l2)}
          else {l.next = l2; iterate(l.next, l1, l2.next)}
        }
      }
    }
    iterate(s, l1, l2)
  }

}
