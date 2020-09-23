// https://leetcode.com/problems/closest-binary-search-tree-value-ii/
object lt272 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def closestKValues(root: TreeNode, target: Double, k: Int): List[Int] = {
    import scala.collection.mutable.ArrayDeque

    val ans = ArrayDeque.empty[Int]

    def dfs(node: TreeNode): Unit = {
      if (node != null) {
        dfs(node.left)
        if (ans.length == k) {
          if (math.abs(target - node.value) < math.abs(target - ans.head))
            ans.removeHead()
          else return
        }
        ans.addOne(node.value)
        dfs(node.right)
      }
    }

    dfs(root)
    ans.toList
  }

  def closestKValues2(root: TreeNode, target: Double, k: Int): List[Int] = {
    import scala.collection.mutable.{Stack, ListBuffer}

    val pred = Stack.empty[TreeNode]
    val succ = Stack.empty[TreeNode]
    val ans = ListBuffer.empty[Int]
    var curr = root
    while (curr != null) {
      if (curr.value >= target) {
        succ.prepend(curr)
        curr = curr.left
      } else {
        pred.prepend(curr)
        curr = curr.right
      }
    }

    def getSuccessor: Int = {
      val item = succ.pop()
      var curr = item.right
      while (curr != null) {
        succ.prepend(curr)
        curr = curr.left
      }
      item.value
    }

    def getPredecessor: Int = {
      val item = pred.pop()
      var curr = item.left
      while (curr != null) {
        pred.prepend(curr)
        curr = curr.right
      }
      item.value
    }

    var count = k
    while (count > 0 && !(pred.isEmpty && succ.isEmpty)) {
      if (pred.isEmpty)
        ans.addOne(getSuccessor)
      else if (succ.isEmpty)
        ans.addOne(getPredecessor)
      else if (math.abs(target - pred.head.value) < math.abs(target - succ.head.value))
        ans.addOne(getPredecessor)
      else
        ans.addOne(getSuccessor)

      count -= 1
    }
    ans.toList
  }
}
