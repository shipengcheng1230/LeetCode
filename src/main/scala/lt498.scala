// https://leetcode.com/problems/diagonal-traverse/
object lt498 {
  def findDiagonalOrder(matrix: Array[Array[Int]]): Array[Int] = {
    if (matrix.isEmpty || matrix.head.isEmpty) return Array.empty[Int]

    import scala.collection.mutable
    val map = mutable.Map.empty[Int, mutable.ArrayBuffer[Int]]
    val m = matrix.length
    val n = matrix.head.length
    val ans = mutable.ArrayBuffer.empty[Int]
    for {
      i <- 0 until m
      j <- 0 until n
    } {
      val sum = i + j
      map.update(sum, map.getOrElse(sum, mutable.ArrayBuffer.empty[Int]).addOne(matrix(i)(j)))
    }

    (0 until m + n - 1).foreach(index => {
      val record = map(index)
      val arr = if (index % 2 != 0) record else record.reverse
      ans.addAll(arr.toArray)
    })
    ans.toArray
  }
}
