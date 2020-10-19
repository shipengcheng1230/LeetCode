// https://leetcode.com/problems/graph-connectivity-with-threshold/
object lt1627 {
  def areConnected(n: Int, threshold: Int, queries: Array[Array[Int]]): List[Boolean] = {

    val parent = Array.tabulate(n + 1)(identity)
    val rank = Array.fill(n + 1)(0)

    def find(a: Int): Int = {
      if (parent(a) != a) parent(a) = find(parent(a))
      parent(a)
    }

    def union(a: Int, b: Int): Unit = {
      val pa = find(a)
      val pb = find(b)
      if (pa != pb) {
        val ra = rank(pa)
        val rb = rank(pb)
        if (ra < rb) parent(pa) = pb
        else if (ra > rb) parent(pb) = pa
        else {
          parent(pb) = pa
          rank(pa) += 1
        }
      }
    }

    def setup(): Unit = {
      for (i <- threshold + 1 to n; j <- i to n by i) {
        union(i, j)
      }
    }

    setup()
    queries.map(x => parent(x(0)) == parent(x(1))).toList
  }
}
