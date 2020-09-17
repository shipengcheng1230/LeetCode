// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
object lt1101 {
  def earliestAcq(logs: Array[Array[Int]], N: Int): Int = {
    val parent = Array.tabulate(N)(identity)
    val rank = Array.fill(N)(0)
    var count = N

    def find(i: Int): Int = {
      if (parent(i) != i) parent(i) = find(parent(i))
      parent(i)
    }

    def union(x: Int, y: Int): Unit = {
      val px = find(x)
      val py = find(y)
      if (px != py) {
        if (rank(px) > rank(py)) parent(py) = px
        if (rank(px) < rank(py)) parent(px) = py
        else {
          parent(py) = px
          rank(px) += 1
        }
        count -= 1
      }
    }

    logs.sortBy(_(0)).foreach(log => {
      union(log(1), log(2))
      if (count == 1) return log(0)
    })

    -1
  }
}
