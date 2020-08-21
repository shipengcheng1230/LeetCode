// https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
object lt428 {

  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

  class Codec {
    import scala.collection.mutable

    // Encodes a tree to a single string.
    def serialize(root: Node): String = {
      if (root == null) return ""

      def helper(root: Node, sb: StringBuilder): Unit = {
        val q = mutable.Queue.empty[Node]
        val end = new Node(0)
        val children = new Node(0)
        q.enqueue(root)
        q.enqueue(end)
        while (q.nonEmpty) {
          val node = q.dequeue()
          if (node == end) {
            sb.append("#")
            if (q.nonEmpty) q.enqueue(end)
          } else if (node == children) {
            sb.append("$")
          } else {
            sb.addOne((node.value + '0').toChar)
            node.children.foreach(x => q.enqueue(x))
            if (q.head != end) q.enqueue(children)
          }
        }
      }

      val sb = new StringBuilder
      helper(root, sb)
      sb.toString()
    }

    // Decodes your encoded data to tree.
    def deserialize(data: String): Node = {
      if (data.isEmpty) return null

      def helper(root: Node): Unit = {
        var currentQ = mutable.Queue.empty[Node]
        var previousQ = mutable.Queue.empty[Node]
        var parent = root
        currentQ.enqueue(root)
        data.tail.foreach(c => {
          if (c == '#') {
            previousQ = currentQ
            currentQ = mutable.Queue.empty[Node]
            parent = previousQ.dequeueFirst(_ => true).orNull
          } else if (c == '$') {
            parent = previousQ.dequeueFirst(_ => true).orNull
          } else {
            val childNode = new Node(c - '0')
            currentQ.enqueue(childNode)
            parent.children = parent.children.appended(childNode)
          }
        })
      }

      val root = new Node(data.head - '0')
      helper(root)
      root
    }
  }

  def main(args: Array[String]): Unit = {
    val c = new Codec
    val r = (1 to 6).map(x => x -> new Node(x)).toMap
    r(1).children = List(r(3), r(2), r(4))
    r(3).children = List(r(5), r(6))
    val s = c.serialize(r(1))
    println(s)
    c.deserialize(s)
  }
}
