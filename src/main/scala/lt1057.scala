// https://leetcode.com/problems/campus-bikes/
object lt1057 {
  def assignBikes(workers: Array[Array[Int]], bikes: Array[Array[Int]]): Array[Int] = {
    import scala.collection.mutable

    val distances = mutable.ArrayBuffer.empty[(Int, Int, Int)]
    workers.zipWithIndex.foreach(wi => {
      bikes.zipWithIndex.foreach(bi => {
        val distance = math.abs(wi._1(0) - bi._1(0)) + math.abs(wi._1(1) - bi._1(1))
        distances.addOne((distance, wi._2, bi._2))
      })
    })
    distances.sortInPlace()
    val ans = Array.fill(workers.length)(-1)
    val taken = mutable.Set.empty[Int]
    distances.foreach(x => {
      val (dist, i, j) = x
      if (ans(i) == -1 && !taken.contains(j)) {
        ans(i) = j
        taken.add(j)
      }
    })
    ans
  }
}
