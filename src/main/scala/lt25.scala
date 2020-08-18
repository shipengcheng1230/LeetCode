
// https://leetcode.com/problems/reverse-nodes-in-k-group/
object lt25 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  import scala.annotation.tailrec

  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    var _head = head
    var ptr = _head
    var ktail: ListNode = null
    var new_head: ListNode = null

    while (ptr != null) {
      var count = 0
      ptr = _head
      while (count < k && ptr != null) {
        ptr = ptr.next
        count += 1
      }
      if (count == k) {
        val revHead = reverse(_head, k)
        if (new_head == null) new_head = revHead
        if (ktail != null) ktail.next = revHead
        ktail = _head
        _head = ptr
      }
    }
    if (ktail != null) ktail.next = _head
    if (new_head == null) _head else new_head
  }

  def reverse(head: ListNode, k: Int): ListNode = {
    @tailrec
    def helper(ptr: ListNode, head: ListNode, count: Int): ListNode = {
      if (count == k) head
      else {
        val next = ptr.next
        ptr.next = head
        helper(next, ptr, count + 1)
      }
    }
    helper(head, null, 0)
  }

  def main(args: Array[String]): Unit = {
    val nodes = (1 to 5).map(x => new ListNode(x, null))
    nodes.sliding(2, 1).foreach(x => x.head.next = x.last)
    val rev = reverseKGroup(nodes.head, 2)
    Seq.unfold(rev)({
      case null => None
      case node => Some(node, node.next)
    }).foreach(x => println(x.x))
  }
}
