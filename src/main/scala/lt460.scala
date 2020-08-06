object lt460 {

  case class Node(k: Int, var v: Int, var freq: Int, var prev: Node, var next: Node)

  class DLinkedList {
    val root: Node = Node(-1, -1, -1, null, null)
    root.next = root
    root.prev = root
    var size = 0

    def append(node: Node): Unit = {
      node.next = root.next
      node.prev = root
      node.next.prev = node
      root.next = node
      size += 1
    }

    def pop(node: Option[Node]): Option[Node] = {
      if (size == 0) None
      else {
        val n = node match {
          case None => root.prev
          case Some(x) => x
        }
        n.prev.next = n.next
        n.next.prev = n.prev
        size -= 1
        Some(n)
      }
    }
  }

  class LFUCache(_capacity: Int) {

    import scala.collection.mutable

    val node = mutable.Map.empty[Int, Node]
    val freq = mutable.Map.empty[Int, DLinkedList]
    var minFreq = 0
    var size = 0

    def update(node: Node): Unit = {
      val _freq = node.freq
      freq(_freq).pop(Some(node))
      if (minFreq == _freq && freq(_freq).size == 0) minFreq += 1
      node.freq += 1
      val dl = freq.getOrElseUpdate(node.freq, new DLinkedList)
      dl.append(node)
    }

    def get(key: Int): Int = {
      if (node.contains(key)) {
        val n = node(key)
        update(n)
        n.v
      } else -1
    }

    def put(key: Int, value: Int): Unit = {
      if (_capacity == 0) return
      if (node.contains(key)) {
        val n = node(key)
        update(n)
        n.v = value
      } else {
        if (size == _capacity) {
          val n = freq(minFreq).pop(None).get
          node.remove(n.k)
          size -= 1
        }
        val nn = Node(key, value, 1, null, null)
        node.update(key, nn)
        val f1 = freq.getOrElseUpdate(1, new DLinkedList)
        f1.append(nn)
        minFreq = 1
        size += 1
      }
    }
  }

  def main(args: Array[String]): Unit = {

//    ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
//    [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]

    var c = new LFUCache(2)
    c.put(1, 1)
    c.put(2, 2)
    println(c.get(1))
    c.put(3, 3)
    println(c.get(2))
    println(c.get(3))
    c.put(4, 4)
    println(c.get(1))
    println(c.get(3))
    println(c.get(4))
    println("")
//    ["LFUCache","put","put","get","get","get","put","put","get","get","get","get"]
//    [[3],[2,2],[1,1],[2],[1],[2],[3,3],[4,4],[3],[2],[1],[4]]

    c = new LFUCache(3)
    c.put(2,2)
    c.put(1,1)
    println(c.get(2))
    println(c.get(1))
    println(c.get(2))
    c.put(3,3)
    c.put(4,4)
    println(c.get(3))
    println(c.get(2))
    println(c.get(1))
    println(c.get(4))
  }

}
