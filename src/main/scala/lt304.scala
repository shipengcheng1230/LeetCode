// https://leetcode.com/problems/range-sum-query-2d-immutable/
object lt304 {
  class NumMatrix(_matrix: Array[Array[Int]]) {

    val dp: Array[Array[Int]] = if (_matrix.isEmpty || _matrix.head.isEmpty) null
              else Array.ofDim(_matrix.length + 1, _matrix.head.length + 1)

    if (dp != null) {
      _matrix.indices.foreach(r => {
        _matrix.head.indices.foreach(c => {
          dp(r + 1)(c + 1) = dp(r + 1)(c) + dp(r)(c + 1) + _matrix(r)(c) - dp(r)(c)
        })
      })
    }

    def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
      if (dp == null) 0
      else dp(row2 + 1)(col2 + 1) - dp(row1)(col2 + 1) - dp(row2 + 1)(col1) + dp(row1)(col1)
    }

  }
}
