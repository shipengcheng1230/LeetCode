// https://leetcode.com/problems/intersection-of-two-linked-lists/
object lt160 {
  class ListNode(var _x: Int = 0) {
    var next: ListNode = _
    var x: Int = _x
  }

  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    if (headA == null || headB == null) null
    else {
      var a = headA
      var b = headB
      while (a != b) {
        a = if (a == null) headB else a.next
        b = if (b == null) headA else b.next
      }
      a
    }
  }
}
