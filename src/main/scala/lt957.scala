
object lt957 {

  def nextDay(bit: Int): Int = {
    (~(bit << 1) ^ (bit >> 1)) & 0x7e // 0x7e == 126 == [01111110]
  }

  def prisonAfterNDays(cells: Array[Int], N: Int): Array[Int] = {
    import scala.collection.mutable
    import scala.annotation.tailrec

    val seen = mutable.Map.empty[Int, Int]
    val state = cells.foldLeft(0x0)((acc, x) => (acc << 1) | x)

    @tailrec
    def simulate(curr: Int, n: Int, leap: Boolean): Int = {
      if (n == N) return curr
      if (leap) simulate(nextDay(curr), n + 1, true)
      else {
        if (seen.contains(curr)) {
          simulate(curr, N - (N - seen(curr)) % (n - seen(curr)), true)
        }
        else {
          seen.update(curr, n)
          simulate(nextDay(curr), n + 1, false)
        }
      }
    }

    val ret = simulate(state, 0, false)
    ("0000000" + ret.toBinaryString).toArray.map(_.toInt - 48).takeRight(8)
  }

  def main(args: Array[String]): Unit = {
    print(prisonAfterNDays(Array(0, 1, 0, 1, 1, 0, 0, 1), 7).mkString("Array(", ", ", ")"))
  }
}
