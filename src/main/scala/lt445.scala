// https://leetcode.com/problems/add-two-numbers-ii/
object lt445 {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    f(clist(l1), clist(l2), 0, null)
  }

  @scala.annotation.tailrec
  def f(l1: List[Int], l2: List[Int], carry: Int, head: ListNode): ListNode = (l1, l2) match {
    case (h :: t, Nil) => f(t, Nil, getCarry(h, 0, carry), updateHead(head)(h, 0, carry))
    case (Nil, h :: t) => f(Nil, t, getCarry(0, h, carry), updateHead(head)(0, h, carry))
    case (h1 :: t1, h2 :: t2) => f(t1, t2, getCarry(h1, h2, carry), updateHead(head)(h1, h2, carry))
    case (Nil, Nil) => if (carry != 0) updateHead(head)(0, 0, carry) else head
  }

  def getCarry(x: Int, y: Int, c: Int): Int = (x + y + c) / 10

  def updateHead(head: ListNode)(x: Int, y: Int, c: Int): ListNode = {
    val ans = new ListNode((x + y + c) % 10)
    ans.next = head
    ans
  }

  @scala.annotation.tailrec
  def clist(l: ListNode, acc: List[Int] = Nil): List[Int] = if (l == null) acc else clist(l.next, l.x :: acc)
}
