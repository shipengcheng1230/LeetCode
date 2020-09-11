// https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
object lt446 {
  def numberOfArithmeticSlices(A: Array[Int]): Int = {
    import scala.collection.mutable

    val n = A.length
    var ans = 0
    val cnt = Array.fill(n)(mutable.Map.empty[Int, Int])
    for (i <- 0 until n; j <- 0 until i) {
      val d = A(i).toLong - A(j)
      if (d >= Int.MinValue && d <= Int.MaxValue) {
        val diff = d.toInt
        val sum = cnt(j).getOrElse(diff, 0)
        val origin = cnt(i).getOrElse(diff, 0)
        // + 1 denote weak seq (j, i)
        // `sum` denote newly formed valid seq
        cnt(i).update(diff, origin + sum + 1)
        ans += sum
      }
    }
    ans
  }
}
