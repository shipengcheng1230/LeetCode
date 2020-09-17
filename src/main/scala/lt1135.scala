// https://leetcode.com/problems/connecting-cities-with-minimum-cost/
object lt1135 {
  def minimumCost(N: Int, connections: Array[Array[Int]]): Int = {

    var count = N
    var ans = 0
    val parent = Array.tabulate(N + 1)(identity)
    val rank = Array.fill(N + 1)(0)
    val sortedConnection = connections.sortBy(_(2))

    def find(parent: Array[Int], i: Int): Int = {
      if (parent(i) != i) parent(i) = find(parent, parent(i))
      parent(i)
    }

    def union(parent: Array[Int], x: Int, y: Int, cost: Int): Unit = {
      val px = find(parent, x)
      val py = find(parent, y)
      if (px != py) {
        if (rank(px) > rank(py)) parent(py) = px
        else if (rank(px) < rank(py)) parent(px) = py
        else {
          parent(py) = px
          rank(px) += 1
        }
        count -= 1
        ans += cost
      }
    }

    sortedConnection.foreach(connect => {
      val c1 = connect(0)
      val c2 = connect(1)
      val cost = connect(2)
      union(parent, c1, c2, cost)
    })

    if (count != 1) -1 else ans
  }
}
