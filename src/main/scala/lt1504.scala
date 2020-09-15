// https://leetcode.com/problems/count-submatrices-with-all-ones/
object lt1504 {
  def numSubmat(mat: Array[Array[Int]]): Int = {
    if (mat.isEmpty || mat.head.isEmpty) 0
    else {
      val m = mat.length
      val n = mat.head.length
      var ans = 0

      def countOneRow(A: Array[Int]): Int = {
        var ans = 0
        var length = 0
        A.foreach(a => {
          if (a == 0) length = 0 else length += 1
          ans += length
        })
        ans
      }

      for (up <- 0 until m) {
        val h = Array.fill(n)(1)
        for (down <- up until m) {
          for (k <- 0 until n)
            h(k) &= mat(down)(k)

          ans += countOneRow(h)
        }
      }
      ans
    }
  }

  // histogram
  def numSubmat2(mat: Array[Array[Int]]): Int = {
    val m = mat.length
    val n = mat.head.length
    var ans = 0

    // continuous `1` at column `j` from row `i` up to row `0`
    val heights = Array.ofDim[Int](n)
    for (i <- 0 until m) {
      val stack = scala.collection.mutable.Stack.empty[(Int, Int)]
      for (j <- 0 until n) {
        if (mat(i)(j) == 0) heights(j) = 0 else heights(j) += 1
        var sum = 0
        while (stack.nonEmpty && heights(stack.head._1) >= heights(j))
          stack.pop()

        // there is shorter column, cut at that
        if (stack.nonEmpty) sum += heights(j) * (j - stack.head._1) + stack.head._2
        // no shorter column, can extend to the left margin
        else sum += heights(j) * (j + 1)

        stack.push((j, sum))
        ans += sum
      }
    }
    ans
  }
}
