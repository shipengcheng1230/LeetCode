// https://leetcode.com/problems/number-of-islands-ii/
object lt305 {
  def numIslands2(m: Int, n: Int, positions: Array[Array[Int]]): List[Int] = {
    import scala.collection.mutable

    val ans = mutable.ListBuffer.empty[Int]
    val parent = Array.fill(m * n)(-1)
    val rank = Array.fill(m * n)(0)
    var count = 0

    def find(root: Array[Int], i: Int): Int = {
      if (root(i) != i) root(i) = find(root, root(i))
      root(i)
    }

    def union(root: Array[Int], rank: Array[Int], x: Int, y: Int): Unit = {
      val rootX = find(root, x)
      val rootY = find(root, y)
      if (rootX != rootY) {
        if (rank(rootX) < rank(rootY)) root(rootX) = rootY
        else if (rank(rootX) > rank(rootY)) root(rootY) = rootX
        else {
          root(rootY) = rootX
          rank(rootX) += 1
        }
        count -= 1
      }
    }

    positions.foreach(pos => {
      val r = pos(0)
      val c = pos(1)
      val overlap = mutable.ListBuffer.empty[Int]
      if (r - 1 >= 0 && parent((r - 1) * n + c) >= 0) overlap.addOne((r - 1) * n + c)
      if (r + 1 < m && parent((r + 1) * n + c) >= 0) overlap.addOne((r + 1) * n + c)
      if (c - 1 >= 0 && parent(r * n + c - 1) >= 0) overlap.addOne(r * n + c - 1)
      if (c + 1 < n && parent(r * n + c + 1) >= 0) overlap.addOne(r * n + c + 1)

      val index = r * n + c
      // for duplicated islands
      if (parent(index) == -1) {
        parent(index) = index
        count += 1
        overlap.foreach(o => union(parent, rank, o, index))
        ans.addOne(count)
      } else ans.addOne(count)
    })
    ans.toList
  }
}
