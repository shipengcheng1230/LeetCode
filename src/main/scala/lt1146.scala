// https://leetcode.com/problems/snapshot-array/
object lt1146 {
  class SnapshotArray(_length: Int) {
    import scala.collection.mutable

    var nsnaps = 0
    val cache: Map[Int, mutable.Map[Int, Int]] = (0 until _length).map(i => i -> mutable.Map(0 -> 0)).toMap

    def set(index: Int, `val`: Int): Unit = {
      cache(index).update(nsnaps, `val`)
    }

    def snap(): Int = {
      nsnaps += 1
      nsnaps - 1
    }

    def get(index: Int, snap_id: Int): Int = {
      cache(index).get(snap_id) match {
        case Some(x) => x
        case None => get(index, snap_id - 1)
      }
    }
  }
}
