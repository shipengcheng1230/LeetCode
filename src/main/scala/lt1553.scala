// https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
object lt1553 {
  def minDays(n: Int): Int = {
    val memo = scala.collection.mutable.Map.empty[Int, Int]

    def helper(n: Int): Int = {
      if (n <= 2) n
      else memo.getOrElseUpdate(n, {
        1 + math.min(helper(n / 2) + n % 2, helper(n / 3) + n % 3)
      })
    }

    helper(n)
  }

  def main(args: Array[String]): Unit = {
    println(minDays(20))
  }
}
