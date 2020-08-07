object lt85 {
  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    if (matrix.isEmpty) return 0
    val m = matrix.length
    val n = matrix.head.length
    val left = Array.fill(n)(0)
    val right = Array.fill(n)(n)
    val height = Array.fill(n)(0)
    var maxA = 0

    (0 until m).foreach(i => {
      var cur_left = 0
      var cur_right = n

      (0 until n).foreach(j => {
        if (matrix(i)(j) == '1') height(j) += 1
        else height(j) = 0
      })

      (0 until n).foreach(j => {
        if (matrix(i)(j) == '1') left(j) = left(j) max cur_left
        else {left(j) = 0; cur_left = j + 1}
      })

      (n-1 until -1 by -1).foreach(j => {
        if (matrix(i)(j) == '1') right(j) = right(j) min cur_right
        else {right(j) = n; cur_right = j}
      })

      (0 until n).foreach(j => {
        maxA = maxA max (right(j) - left(j)) * height(j)
      })

    })

    maxA
  }
}
