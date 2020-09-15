// https://leetcode.com/problems/design-log-storage-system/
object lt635 {

  class LogSystem() {
    import scala.collection.mutable

    val logs: mutable.SortedMap[String, mutable.ListBuffer[Int]] = mutable.TreeMap
      .empty[String, mutable.ListBuffer[Int]]

    val indexMap = Map("Year" -> 4, "Month" -> 7, "Day" -> 10, "Hour" -> 13, "Minute" -> 16, "Second" -> 19)
    val min = "2000:01:01:00:00:00"
    val max = "2017:12:31:23:59:59"

    def put(id: Int, timestamp: String): Unit = {
      if (!logs.contains(timestamp))
        logs.update(timestamp, mutable.ListBuffer.empty[Int])

      logs(timestamp).addOne(id)
    }

    def retrieve(s: String, e: String, gra: String): List[Int] = {
      val index = indexMap(gra)
      val start = s.substring(0, index) + min.substring(index)
      val end = e.substring(0, index) + max.substring(index)
      logs.rangeFrom(start).rangeTo(end).values.flatten.toList
    }
  }
  def main(args: Array[String]): Unit = {
    val obj = new LogSystem

    obj.put(1,"2017:01:01:23:59:59")
    obj.put(2,"2017:01:01:22:59:59")
    obj.put(3,"2016:01:01:00:00:00")
    println(obj.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"))
  }
}
