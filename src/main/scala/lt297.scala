import scala.collection.mutable

object lt297 {
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }

  object Codec {
    // Encodes a list of strings to a single string.
    def serialize(root: TreeNode): String = {

      def helper(node: TreeNode, s: StringBuilder): Unit = {
        if (node == null) s.append("null,")
        else {
          s.append(s"${node.value},")
          helper(node.left, s)
          helper(node.right, s)
        }
      }

      val sb = new StringBuilder
      helper(root, sb)
      sb.toString()
    }

    // Decodes a single string to a list of strings.
    def deserialize(s: String): TreeNode = {

      var index = 0

      def helper(ss: Array[String]): TreeNode = {
        if (ss(index) == "null") {index += 1; null}
        else {
          val node = new TreeNode(ss(index).toInt)
          index += 1
          node.left = helper(ss)
          node.right = helper(ss)
          node
        }
      }

      helper(s.split(","))
    }

    def serialize2(root: TreeNode): String = {
      if (root == null) return "null"

      val q = mutable.Queue.empty[TreeNode].addOne(root)
      val ss = mutable.ListBuffer.empty[String]

      while (q.nonEmpty) {
        val n = q.dequeue()
        if (n == null) ss += "null"
        else {
          ss += s"${n.value}"
          q.addOne(n.left)
          q.addOne(n.right)
        }
      }
      ss.mkString(",")
    }

    def deserialize2(s: String): TreeNode = {
      if (s == "null") return null
      val data = s.split(",")
      val root = new TreeNode(data.head.toInt)
      val q = mutable.Queue.empty[TreeNode].addOne(root)
      var i = 1

      while (q.nonEmpty) {
        val n = q.dequeue()
        if (data(i) != "null") {
          n.left = new TreeNode(data(i).toInt); q.addOne(n.left)
        }
        i += 1
        if (data(i) != "null") {
          n.right = new TreeNode(data(i).toInt); q.addOne(n.right)
        }
        i += 1
      }
      root
    }
  }

  def main(args: Array[String]): Unit = {
    import Codec._

    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.right = new TreeNode(3)
    root.right.left = new TreeNode(4)
    root.right.right = new TreeNode(5)

    print(deserialize2(serialize2(root)))
  }
}
