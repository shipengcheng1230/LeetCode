object lt403 {

  import scala.collection.mutable

  def canCross(stones: Array[Int]): Boolean = {
    val memo = mutable.Map(stones.map(x => (x, mutable.Set.empty[Int])).toIndexedSeq: _*)
    memo.update(0, memo(0).addOne(0))

    stones.foreach(stone => memo(stone).foreach(k => {
      (k-1 to k+1).foreach(step => {
        if (step > 0 && memo.contains(step + stone)) memo(step + stone).addOne(step)
      })
    }))
    memo(stones.last).nonEmpty
  }
}
