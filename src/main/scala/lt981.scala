// https://leetcode.com/problems/time-based-key-value-store/
object lt981 {
  class TimeMap() {
    import scala.collection.mutable.{Map => MM, TreeMap => MT}
    val cache: MM[String, MT[Int, String]] = MM.empty[String, MT[Int, String]]

    def set(key: String, value: String, timestamp: Int): Unit = {
      if (!cache.contains(key)) cache.update(key, MT.empty[Int, String])
      cache(key).addOne((timestamp, value))
    }

    def get(key: String, timestamp: Int): String = {
      if (!cache.contains(key)) ""
      else {
        cache(key).rangeTo(timestamp) match {
          case x if x.isEmpty => ""
          case x => x.last._2
        }
      }
    }
  }
}
