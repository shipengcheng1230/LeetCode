// https://leetcode.com/problems/design-hit-counter/
object lt362 {
  class HitCounter() {

    import scala.collection.mutable

    /** Initialize your data structure here. */
    val cache: mutable.TreeMap[Int, Int] = mutable.TreeMap.empty[Int, Int]

    /** Record a hit.
    @param timestamp - The current timestamp (in seconds granularity). */
    def hit(timestamp: Int): Unit = {
      cache.update(timestamp, cache.getOrElse(timestamp, 0) + 1)
    }

    /** Return the number of hits in the past 5 minutes.
    @param timestamp - The current timestamp (in seconds granularity). */
    def getHits(timestamp: Int): Int = {
      cache.rangeFrom(timestamp - 299).rangeTo(timestamp).values.sum
    }

  }
}
