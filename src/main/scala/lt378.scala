// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
object lt378 {
  def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
    var lo = matrix.head.head
    var hi = matrix.last.last + 1
    while (lo < hi) {
      val mid = lo + (hi - lo) / 2
      var count = 0
      var j = matrix.head.length - 1
      matrix.indices.foreach(i => {
        while (j >= 0 && matrix(i)(j) > mid)
          j -= 1
        count += j + 1
      })
      if (count < k) lo = mid + 1
      else hi = mid
    }
    lo
  }
}
