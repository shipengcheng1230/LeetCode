// https://leetcode.com/problems/sliding-window-median/
object lt480 {
  def medianSlidingWindow(nums: Array[Int], k: Int): Array[Double] = {
    import scala.collection.mutable

    val lo = mutable.TreeSet.empty[Int](Ordering[(Int, Int)].on(x => (nums(x), x)))
    val hi = lo.clone()
    val ans = Array.fill(nums.length - k + 1)(0.0)

    var start = 0
    nums.indices.foreach(i => {
      lo.addOne(i)
      hi.addOne(lo.last)
      lo.remove(lo.last)
      if (hi.size > lo.size) {
        lo.addOne(hi.head)
        hi.remove(hi.head)
      }
      if (lo.size + hi.size == k) {
        if (lo.size == hi.size)
          ans(start) = (nums(lo.last).toLong + nums(hi.head).toLong) / 2.0
        else
          ans(start) = nums(lo.last).toDouble
        if (!lo.remove(start))
          hi.remove(start)
        start += 1
      }
    })
    ans
  }

  def main(args: Array[String]): Unit = {
    println(medianSlidingWindow(Array(1,3,-1,-3,5,3,6,7), 3).toList)
  }
}
