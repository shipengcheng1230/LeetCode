// https://leetcode.com/problems/sort-the-matrix-diagonally/
object lt1329 {
  def diagonalSort(mat: Array[Array[Int]]): Array[Array[Int]] = {
    import scala.collection.mutable.{Map, ArrayDeque}

    val cache = Map.empty[Int, ArrayDeque[Int]]
    val m = mat.length
    val n = mat.head.length
    for (i <- 0 until m; j <- 0 until n) {
      cache.getOrElseUpdate(j - i, ArrayDeque.empty[Int]).append(mat(i)(j))
    }
    cache.values.foreach(_.sortInPlace)

    val ans = Array.ofDim[Int](m, n)
    for (i <- 0 until m; j <- 0 until n) {
      ans(i)(j) = cache(j - i).removeHead()
    }
    ans
  }
}
