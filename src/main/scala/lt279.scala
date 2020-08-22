// https://leetcode.com/problems/perfect-squares/
object lt279 {
  def numSquares(n: Int): Int = {

    val sn = (1 to math.sqrt(n).floor.toInt).map(x => x * x).toSet

    def dividable(n: Int, count: Int): Boolean = {
      if (count == 1) sn.contains(n)
      else {
        sn.foreach(k => if (dividable(n - k, count - 1)) return true)
        false
      }
    }

    (1 to n).foreach(i => if (dividable(n ,i)) return i)
    n + 1
  }

  def main(args: Array[String]): Unit = {
    print(numSquares(19))
  }
}
