// https://leetcode.com/problems/design-underground-system/
object lt1396 {
  class UndergroundSystem() {

    import scala.collection.mutable

    val checkInData = mutable.Map.empty[Int, (String, Int)]
    val averageData = mutable.Map.empty[String, (Int, Int)]

    def checkIn(id: Int, stationName: String, t: Int): Unit = {
      checkInData.update(id, (stationName, t))
    }

    def checkOut(id: Int, stationName: String, t: Int): Unit = {
      val (startStation, checkInTime) = checkInData(id)
      val key = keystr(startStation, stationName)
      val (totalTime, count) = averageData.getOrElse(key, (0, 0))
      averageData.update(key, (totalTime + t - checkInTime, count + 1))
    }

    def keystr(startStation: String, endStation: String): String =
      startStation + ">>" + endStation

    def getAverageTime(startStation: String, endStation: String): Double = {
      val ans = averageData(keystr(startStation, endStation))
      ans._1 / ans._2.toDouble
    }
  }

  def main(args: Array[String]): Unit = {
    val u = new UndergroundSystem
    u.checkIn(10, "Leyton", 3)
    u.checkOut(10, "Paradise", 8)
    println(u.getAverageTime("Leyton", "Paradise"))

    u.checkIn(5, "Leyton", 10)
    u.checkOut(5, "Paradise", 16)
    println(u.getAverageTime("Leyton", "Paradise"))

  }
}
