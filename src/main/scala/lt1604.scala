// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
object lt1604 {
  def alertNames(keyName: Array[String], keyTime: Array[String]): List[String] = {
    import scala.collection.mutable.{Map, ArrayDeque, Set}

    val name2record = Map.empty[String, ArrayDeque[Int]]
    val ans = Set.empty[String]

    def time2int(s: String): Int = {
      val Array(hour, minute) = s.split(":").map(_.toInt)
      hour * 60 + minute
    }

    keyName.zip(keyTime).sortBy(_._2).foreach { case (name, time) =>
      if (!ans.contains(name)) {
        val t = time2int(time)
        val record = name2record.getOrElseUpdate(name, ArrayDeque.empty[Int])
        if (record.length < 2) record.append(t)
        else {
          val dt = t - record.head
          if (dt <= 60 && dt >= 0) ans.addOne(name)
          record.removeHead()
          record.append(t)
        }
      }
    }

    ans.toList.sorted
  }
}
