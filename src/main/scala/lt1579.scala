// https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
object lt1579 {
  def maxNumEdgesToRemove(n: Int, edges: Array[Array[Int]]): Int = {
    var na = n
    var nb = n
    // root of each node
    val psa = Array.tabulate(n + 1)(identity)
    val psb = psa.clone()
    var res = 0

    def count(`type`: Int): Unit = {
      edges.foreach(e => {
        if (e(0) == `type`) {
          if (`type` == 3 && !union(1, e) && !union(2, e)) res += 1
          else if (!union(`type`, e)) res += 1
        }
      })
    }

    // whether edge `e` is not redundant in each island
    def union(`type`: Int, e: Array[Int]): Boolean = {
      val ps = if (`type` == 1) psa else psb
      val up = find(e(1), ps)
      val vp = find(e(2), ps)
      if (up == vp) false
      else {
        ps(up) = vp
        if (`type` == 1) na -= 1 else nb -= 1
        true
      }
    }

    def find(node: Int, ps: Array[Int]): Int = {
      val p = ps(node)
      if (node != p) ps(node) = find(ps(node), ps)
      ps(node)
    }

    count(3)
    count(2)
    count(1)
    if (na != 1 || nb != 1) -1 else res
  }
}
