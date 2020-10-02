// https://leetcode.com/problems/sequence-reconstruction/
object lt444 {
  def sequenceReconstruction(org: Array[Int], seqs: List[List[Int]]): Boolean = {
    if (org.isEmpty || seqs.isEmpty) return false

    import scala.collection.mutable.{Set, Map, Queue, ArrayBuffer}
    val graph = Map.empty[Int, Set[Int]]
    for (seq <- seqs; i <- 1 until seq.size) {
      graph.getOrElseUpdate(seq(i - 1), Set.empty[Int]).addOne(seq(i))
    }

    val topo = ArrayBuffer.empty[Int]
    val in = Map.empty[Int, Int]
    val s = Set.empty[Int]
    val seen = Set.empty[Int]
    graph.values.foreach(vs => vs.foreach(v => in.update(v, in.getOrElse(v, 0) + 1)))
    seqs.flatten.toSet.foreach((x: Int) => if (!in.contains(x)) s.addOne(x))
    val q = s.to(Queue)
    println(in, s.toList)
    while (q.nonEmpty) {
      if (q.size > 1) return false
      val front = q.dequeue()
      seen.addOne(front)
      topo.addOne(front)
      val tos = graph.getOrElse(front, None)
      tos.iterator.foreach(to => {
        in.update(to, in(to) - 1)
        if (in(to) == 0 && !seen.contains(to)) {
          q.enqueue(to)
          in.remove(to)
        }
      })
    }

    org.sameElements(topo) && in.isEmpty
  }

  def sequenceReconstruction2(org: Array[Int], seqs: List[List[Int]]): Boolean = {
    import scala.collection.mutable.Set

    val d = org.zipWithIndex.map(x => x._1 -> x._2).toMap
    val visited = Set.empty[Int]
    seqs.foreach(nums => {
      var prevNum = -1
      var prevIdx = -1
      nums.foreach(num => {
        if (!d.contains(num)) return false
        val currIdx = d(num)
        if (prevIdx == currIdx - 1 && !visited.contains(num)) visited.addOne(num)
        else if (prevIdx >= currIdx) return false
        prevNum = num
        prevIdx = currIdx
      })
    })
    visited.size == org.length
  }

  def main(args: Array[String]): Unit = {
    println(sequenceReconstruction2(Array(4,1,5,2,6,3), List(List(5,2,6,3),List(4,1,5,2))))
  }
}
