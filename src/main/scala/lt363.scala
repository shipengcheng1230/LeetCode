// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
object lt363 {
  def maxSumSubmatrix(matrix: Array[Array[Int]], k: Int): Int = {
    import scala.collection.mutable

    if (matrix.isEmpty || matrix.head.isEmpty) 0 else {
      val m = matrix.length
      val n = matrix.head.length
      var ans = Int.MinValue

      for { begin <- 0 until n; end <- begin + 1 to n } {
        val arr = Array.fill(m)(0)
        for { i <- 0 until m; j <- begin until end }
          arr(i) += matrix(i)(j)

        val treeSet = mutable.TreeSet.empty[Int]
        var cumulative = 0
        treeSet.addOne(cumulative)
        arr.foreach(a => {
          cumulative += a
          val ceiling = treeSet.rangeFrom(cumulative - k)
          if (ceiling.nonEmpty)
            ans = ans max (cumulative - ceiling.head)
          treeSet.addOne(cumulative)
        })
      }
      ans
    }
  }
}
