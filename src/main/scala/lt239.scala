// https://leetcode.com/problems/sliding-window-maximum/
object lt239 {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    import scala.collection.mutable

    val q = mutable.ArrayDeque.empty[Int]

    def clean(i: Int): Unit = {
      if (q.nonEmpty && i - k == q.head) q.removeHead()
      while (q.nonEmpty && nums(i) > nums(q.last)) q.removeLast()
    }

    val n = nums.length
    if (n * k == 0) return Array(0)
    if (k == 1) return nums

    val output = Array.fill(n - k + 1)(-1)
    (0 until k).foreach(i => {
      clean(i)
      q.append(i)
    })
    output(0) = nums(q.head)

    (k until n).foreach(i => {
      clean(i)
      q.append(i)
      output(i - k + 1) = nums(q.head)
    })
    output
  }
}
