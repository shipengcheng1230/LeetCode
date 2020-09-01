// https://leetcode.com/problems/n-queens/
object lt51 {
  def solveNQueens(n: Int): List[List[String]] = {

    val ans = scala.collection.mutable.ListBuffer.empty[List[String]]

    def placeQueen(d: Array[Int], r: Int, c: Int): Unit = d(r) = c

    def removeQueen(d: Array[Int], r: Int, c: Int): Unit = d(r) = 0

    def valid(d: Array[Int], r: Int, c: Int): Boolean = {
      val prevCols = (0 until r).map(d(_)).contains(c)
      val prevDiag = (0 until r).exists(x => math.abs(x - r) == math.abs(d(x) - c))
      !(prevCols || prevDiag)
    }

    def helper(k: Int, d: Array[Int]): Unit = {
      if (k == n) {
        val s = d.map(x => "." * (x - 1) + "Q" + "." * (n - x)).toList
        ans.addOne(s)
      }
      else {
        (1 to n).foreach(i => {
          if (valid(d, k, i)) {
            placeQueen(d, k, i)
            helper(k + 1, d)
            removeQueen(d, k, i)
          }
        })
      }
    }

    helper(0, Array.fill(n)(0))
    ans.toList
  }

  def main(args: Array[String]): Unit = {
    solveNQueens(4).foreach(_.foreach(println))
  }
}
