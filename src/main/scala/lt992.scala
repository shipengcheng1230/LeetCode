// https://leetcode.com/problems/subarrays-with-k-different-integers/
object lt992 {
  def subarraysWithKDistinct(A: Array[Int], K: Int): Int = {
    var ans = 0
    val w1 = new Window
    val w2 = new Window
    var l1 = 0
    var l2 = 0

    A.indices.foreach(i => {
      w1.add(A(i))
      w2.add(A(i))

      while (w1.size > K) {
        w1.remove(A(l1))
        l1 += 1
      }
      while (w2.size >= K) {
        w2.remove(A(l2))
        l2 += 1
      }
      ans += l2 - l1
    })
    ans
  }

  class Window {
    val cache = scala.collection.mutable.Map.empty[Int, Int]

    def add(x: Int): Unit = cache.update(x, cache.getOrElse(x, 0) + 1)

    def remove(x: Int): Unit = {
      cache.update(x, cache(x) - 1)
      if (cache(x) == 0) cache.remove(x)
    }

    def size: Int = cache.size
  }
}
