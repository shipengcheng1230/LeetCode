// https://leetcode.com/problems/spiral-matrix/
object lt54 {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    if (matrix.isEmpty || matrix.head.isEmpty) Nil else {
      val ans = scala.collection.mutable.ListBuffer.empty[Int]
      var r1 = 0
      var r2 = matrix.length - 1
      var c1 = 0
      var c2 = matrix.head.length - 1
      while (r1 <= r2 && c1 <= c2) {
        (c1 to c2).foreach(i => ans.append(matrix(r1)(i)))
        (r1+1 to r2).foreach(i => ans.append(matrix(i)(c2)))
        // notice the repeating traverse!
        if (r1 < r2) (c2-1 to c1 by -1).foreach(i => ans.append(matrix(r2)(i)))
        if (c1 < c2) (r2-1 until r1 by -1).foreach(i => ans.append(matrix(i)(c1)))
        r1 += 1
        r2 -= 1
        c1 += 1
        c2 -= 1
      }
      ans.toList
    }
  }
}
