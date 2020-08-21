// https://leetcode.com/problems/reorder-list/
object lt143 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def reorderList(head: ListNode): Unit = {
    import scala.annotation.tailrec

    @tailrec
    def length(node: ListNode, count: Int = 1): Int =
      if (node == null) count else length(node.next, count + 1)

    @tailrec
    def reverse(node: ListNode, head: ListNode = null): ListNode =
      if (node == null) head else {
        val next = node.next
        node.next = head
        reverse(next, node)
      }

    @tailrec
    def splitAtN(node: ListNode, n: Int = 1): ListNode = {
      if (node == null) null
      else {
        if (node.next == null || n == 1) {
          val next = node.next
          node.next = null
          next
        } else splitAtN(node.next, n - 1)
      }
    }

    def merge(n1: ListNode, n2: ListNode): ListNode = {
      var c1 = n1
      var c2 = n2
      while (c1 != null && c2 != null) {
        val c1next = c1.next
        val c2next = c2.next
        c1.next = c2
        c2.next = c1next
        c1 = c1next
        c2 = c2next
      }
      if (c1 != null) c2.next = c1
      n1
    }

    val n = length(head)
    val mid = reverse(splitAtN(head, n / 2))
    merge(head, mid)
  }

  def main(args: Array[String]): Unit = {
    val ns = (1 to 5).map(new ListNode(_, null))
    ns.indices.init.foreach(i => ns(i).next = ns(i + 1))
    println(reorderList(ns.head))
  }
}
