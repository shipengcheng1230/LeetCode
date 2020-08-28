// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
object lt430 {

  class Node(var _value: Int) {
    var value: Int = _value
    var prev: Node = _
    var next: Node = _
    var child: Node = _
  }

  def flatten(head: Node): Node = {
    var tail: Node = null

    def iterate(head: Node): Node = {
      if (head == null) head
      else {
        head.prev = tail
        tail = head
        val next = head.next
        head.next = iterate(head.child)
        head.child = null
        tail.next = iterate(next)
        head
      }
    }

    iterate(head)
  }
}
