// https://leetcode.com/problems/unique-binary-search-trees-ii/
object lt95 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def generateTrees(n: Int): List[TreeNode] = {

    def helper(from: Int, to: Int): List[TreeNode] = {
      if (from > to) List(null)
      else if (from == to) List(new TreeNode(from, null, null))
      else {
        (from to to).flatMap(m => {
          val allLeft = helper(from, m - 1)
          val allRight = helper(m + 1, to)
          for (tl <- allLeft; tr <- allRight) yield new TreeNode(m, tl, tr)
        }).toList
      }
    }

    helper(1, n).filterNot(_ == null)
  }
}
