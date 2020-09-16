// https://leetcode.com/problems/special-positions-in-a-binary-matrix/
object lt1582 {
  def numSpecial(mat: Array[Array[Int]]): Int = {
    var ans = 0
    val m = mat.length
    val n = mat.head.length
    for (i <- 0 until m; if mat(i).sum == 1) {
      var j = 0
      while (j < n && mat(i)(j) != 1) j += 1
      if ((0 until m).map(x => mat(x)(j)).sum == 1) ans += 1
    }
    ans
  }
}
