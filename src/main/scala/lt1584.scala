// https://leetcode.com/problems/min-cost-to-connect-all-points/
object lt1584 {
  def minCostConnectPoints(points: Array[Array[Int]]): Int = {
    val n = points.length
    if (n == 1) return 0
    var ans = 0
    val seen = scala.collection.mutable.Set.empty[Int]
    val dist = Array.fill(n)(Int.MaxValue)
    var curr = 0

    points.indices.init.foreach(_ => {
      seen.addOne(curr)
      points.indices.foreach(j => {
        if (!seen.contains(j)) {
          dist(j) = dist(j) min (math.abs(points(j)(0) - points(curr)(0)) + math.abs(points(j)(1) - points(curr)(1)))
        }
      })
      val (d, minIndex) = dist.zipWithIndex.minBy(_._1)
      curr = minIndex
      ans += d
      dist(curr) = Int.MaxValue
    })
    ans
  }
}
