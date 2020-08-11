import scala.collection.mutable

object lt146 {

  case class KV(var k: Int, var v: Int)
  case class Node(var kv: KV, var prev: Node, var next: Node)

  class LRUClass(val _capacity: Int) {
    val cache = mutable.HashMap.empty[Int, Node]
    var head: Node = Node(KV(-1, -1), null, null)
    var tail: Node = Node(KV(-1, -1), head, null)
    head.next = tail

    def _add_node(n: Node): Unit = {
      n.prev = head
      n.next = head.next
      head.next.prev = n
      head.next = n
    }

    def _remove_node(n: Node): Unit = {
      val prev = n.prev
      val next = n.next
      prev.next = next
      next.prev = prev
    }

    def _move_to_head(n: Node): Unit = {
      _remove_node(n)
      _add_node(n)
    }

    def _pop_tail(): Node = {
      val res = tail.prev
      _remove_node(res)
      res
    }

    def get(key: Int): Int = {
      cache.get(key) match {
        case Some(value) => _move_to_head(value); value.kv.v
        case None => -1
      }
    }

    def put(key: Int, value: Int): Unit = {
      cache.get(key) match {
        case Some(x) => x.kv.v = value; _move_to_head(x)
        case None =>
          val newNode = Node(KV(key, value), null, null)
          cache.update(key, newNode)
          _add_node(newNode)
          if (cache.size > _capacity) {
            val tail = _pop_tail()
            cache.remove(tail.kv.k)
          }
      }
    }
  }

}
