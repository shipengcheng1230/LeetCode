// https://leetcode.com/problems/top-k-frequent-elements/
object lt347 {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    import scala.annotation.tailrec
    import scala.util.Random

    val count = nums.groupMapReduce(identity)(_ => 1)(_ + _)

    def swap(x: Array[Int], a: Int, b: Int): Unit = {
      val tmp = x(a)
      x(a) = x(b)
      x(b) = tmp
    }

    def partition(x: Array[Int], left: Int, right: Int, pivot: Int): Int = {
      val pivotFreq = count(x(pivot))
      swap(x, pivot, right)
      var store = left
      for (i <- left to right) {
        if (count(x(i)) < pivotFreq) {
          swap(x, store, i)
          store += 1
        }
      }
      swap(x, store, right)
      store
    }

    @tailrec
    def quickSelect(x: Array[Int], left: Int, right: Int, ksmallest: Int): Unit = {
      if (left != right) {
        val rand = new Random()
        val pivot = partition(x, left, right, left + rand.nextInt(right - left))
        if (ksmallest == pivot) return
        else if (ksmallest < pivot) quickSelect(x, left, pivot - 1, ksmallest)
        else quickSelect(x, pivot + 1, right, ksmallest)
      }
    }

    val x = count.keySet.toArray
    val n = x.length
    quickSelect(x, 0, n - 1, n - k)
    x.slice(n - k, n)
  }
}
