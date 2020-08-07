
object lt528 {
  class Solution(_w: Array[Int]) {
    val rng = new scala.util.Random()
    val x = _w.scanLeft(0)(_ + _)
    val max = x.last

    def pickIndex(): Int = {
      val t = rng.nextInt(max)
      val i = search(x, t, 0, x.size - 1)
      i
    }

    @scala.annotation.tailrec
    private def search(a: Array[Int], t: Int, l: Int, r: Int): Int = {
      if (l >= r) {
        l
      } else {
        val mid = (r - l) / 2 + l
        if (a(mid) >= t) {
          search(a, t, l, mid)
        } else {
          search(a, t, mid + 1, r)
        }
      }
    }
  }
}
