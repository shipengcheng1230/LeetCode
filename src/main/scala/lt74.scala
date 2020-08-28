// https://leetcode.com/problems/search-a-2d-matrix/
object lt74 {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    if (matrix.isEmpty || matrix.head.isEmpty) false
    else {
      val m = matrix.length
      val n = matrix.head.length
      var l = 0
      var r = m - 1
      var row = -1
      while (l <= r) {
        val mid = (l + r) / 2
        if (matrix(mid)(0) < target)
          l = mid + 1
        else if (matrix(mid)(0) > target)
          r = mid - 1
        else
          return true
      }

      if (r >= 0 && r < m ) {
        row = r
        l = 0
        r = n - 1
        while (l <= r) {
          val mid = (l + r) / 2
          if (matrix(row)(mid) < target)
            l = mid + 1
          else if (matrix(row)(mid) > target)
            r = mid - 1
          else
            return true
        }
      }
      false
    }
  }
}
