// https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/
object lt1585 {
  def isTransformable(s: String, t: String): Boolean = {
    import scala.collection.mutable.ArrayBuffer

    val idx = Array.fill(10)(ArrayBuffer.empty[Int])
    val pos = Array.fill(10)(0)

    s.indices.foreach(i => idx(s(i) - '0').addOne(i))
    t.indices.foreach(i => {
      val d = t(i) - '0'
      if (pos(d) >= idx(d).length) return false
      for (j <- 0 until d) {
        if (pos(j) < idx(j).length && idx(j)(pos(j)) < idx(d)(pos(d)))
          return false
      }
      pos(d) += 1
    })
    true
  }
}
