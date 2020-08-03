import scala.annotation.tailrec
import scala.collection.mutable

object lt138 {

  class Node(var _value: Int) {
    var value: Int = _value
    var next: Node = _
    var random: Node = _
  }

  val visited: mutable.HashMap[Node, Node] = mutable.HashMap[Node, Node]()

  def getClonedNode(n: Node): Node = {
    if (n == null) null
    else visited.getOrElseUpdate(n, new Node(n.value))
  }

  def copyRandomList(head: Node): Node = {

    @tailrec
    def iterate(o: Node, n: Node): Unit = {
      if (o != null) {
        n.random = getClonedNode(o.random)
        n.next = getClonedNode(o.next)
        iterate(o.next, n.next)
      }
    }

    if (head == null) null
    else {
      val oldNode = head
      val newNode = new Node(head.value)
      visited.update(oldNode, newNode)
      iterate(oldNode, newNode)
      visited.getOrElse(head, null)
    }
  }

}
