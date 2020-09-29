// https://leetcode.com/problems/make-sum-divisible-by-p/
object lt1590 {
  def minSubarray(nums: Array[Int], p: Int): Int = {
    import scala.collection.mutable.Map

    val need = nums.foldLeft(0)((x, y) => (x + y) % p)
    if (need == 0) return 0

    val m = Map.empty[Int, Int]
    m.update(0, -1)
    var curr = 0
    var ans = nums.length
    nums.indices.foreach(i => {
      curr = (curr + nums(i)) % p
      m.update(curr, i)
      val want = (curr - need + p) % p
      ans = ans min (i - m.getOrElse(want, -nums.length))
    })
    if (ans == nums.length) -1 else ans
  }
}
