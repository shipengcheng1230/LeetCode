// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
object lt108 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def sortedArrayToBST(nums: Array[Int]): TreeNode = {

    def helper(l: Int, r: Int): TreeNode = {
      if (l > r) null
      else {
        val m = l + (r - l) / 2
        val root = new TreeNode(nums(m))
        root.left = helper(l, m - 1)
        root.right = helper(m + 1, r)
        root
      }
    }

    helper(0, nums.length - 1)
  }

}
