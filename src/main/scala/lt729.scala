// https://leetcode.com/problems/my-calendar-i/
object lt729 {
  class MyCalendar() {
    import scala.collection.mutable.TreeMap

    val cache = TreeMap.empty[Int, Int]

    def book(start: Int, end: Int): Boolean = {
      val prev = cache.rangeTo(start)
      val next = cache.rangeFrom(start)
      if ((prev.isEmpty || prev.last._2 <= start) &&
        (next.isEmpty || next.head._1 >= end)) {
        cache.update(start, end)
        true
      } else false
    }
  }
}
