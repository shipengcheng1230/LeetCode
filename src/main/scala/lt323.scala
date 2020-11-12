// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/submissions/
object lt323 {
  def countComponents(n: Int, edges: Array[Array[Int]]): Int = {

    val parent = Array.tabulate(n)(identity)
    val rank = Array.fill(n)(0)
    var ans = n

    def find(x: Int): Int = {
      if (x != parent(x)) parent(x) = find(parent(x))
      parent(x)
    }

    def union(x: Int, y: Int): Unit = {
      val px = find(x)
      val py = find(y)
      if (px != py) {
        val rx = rank(px)
        val ry = rank(py)
        if (rx < ry) parent(px) = py
        else if (rx > ry) parent(py) = px
        else {
          parent(py) = px
          rank(px) += 1
        }
        ans -= 1
      }
    }

    edges.foreach(e => union(e(0), e(1)))
    ans
  }
}
