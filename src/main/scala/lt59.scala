// https://leetcode.com/problems/spiral-matrix-ii/
object lt59 {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    val matrix = Array.ofDim[Int](n, n)
    var r1 = 0
    var r2 = n - 1
    var c1 = 0
    var c2 = n - 1
    var count = 1
    while (r1 <= r2 && c1 <= c2) {
      (c1 to c2).foreach(i => {
        matrix(r1)(i) = count
        count += 1
      })
      (r1 + 1 to r2).foreach(i => {
        matrix(i)(c2) = count
        count += 1
      })
      if (r1 < r2)
        (c2 - 1 to c1 by -1).foreach(i => {
          matrix(r2)(i) = count
          count += 1
        })
      if (c1 < c2)
        (r2 - 1 until r1 by -1).foreach(i => {
          matrix(i)(c1) = count
          count += 1
        })

      r1 += 1
      r2 -= 1
      c1 += 1
      c2 -= 1
    }
    matrix
  }
}
