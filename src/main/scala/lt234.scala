// https://leetcode.com/problems/palindrome-linked-list/
object lt234 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def isPalindrome(head: ListNode): Boolean = {

    @scala.annotation.tailrec
    def length(node: ListNode, count: Int = 0): Int = {
      if (node == null) count else length(node.next, count + 1)
    }

    @scala.annotation.tailrec
    def reverse(node: ListNode, head: ListNode = null): ListNode = {
      if (node == null) head else {
        val tmp = node.next
        node.next = head
        reverse(tmp, node)
      }
    }

    @scala.annotation.tailrec
    def getNth(node: ListNode, n: Int): ListNode = {
      if (node == null || n == 1) node else getNth(node.next, n - 1)
    }

    @scala.annotation.tailrec
    def compare(n1: ListNode, n2: ListNode): Boolean = {
      if (n1 != null && n2 != null) {
        if (n1.x != n2.x) false else compare(n1.next, n2.next)
      } else true
    }

    val n = length(head)
    val x = reverse(getNth(head, n / 2 + 1))
    compare(head, x)
  }
}
