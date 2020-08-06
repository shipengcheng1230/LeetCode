object lt1152 {

  import scala.collection.mutable.{HashMap, ListBuffer, StringBuilder, HashSet}

  case class Pair(time: Int, web: String)

  def mostVisitedPattern(username: Array[String], timestamp: Array[Int], website: Array[String]): List[String] = {

    val map = HashMap.empty[String, ListBuffer[Pair]]
    username.indices.foreach(i => map.update(username(i), map.getOrElse(username(i), ListBuffer.empty[Pair]).append(Pair(timestamp(i), website(i)))))
    val count = HashMap.empty[String, Int]
    var res = ""

    map.keysIterator.foreach(key => {
      val strs = map(key).sortBy(_.time).map(_.web)
      val set = HashSet.empty[String]
      for {
        i <- strs.indices
        j <- i + 1 until strs.length
        k <- j + 1 until strs.length
      } {
        val sb = new StringBuilder
        val ss = sb.append(strs(i)).append(" ").append(strs(j)).append(" ").append(strs(k)).toString()
        if (!set.contains(ss)) {
          count.update(ss, count.getOrElse(ss, 0) + 1)
          set.addOne(ss)
        }
        if (res.isEmpty || count(res) < count(ss) || (count(res) == count(ss) && res > ss)) res = ss
      }
    })
    res.split(" ").toList
  }

  def main(args: Array[String]): Unit = {
    val a = Array("joe","joe","joe","james","james","james","james","mary","mary","mary")
    val b = Array(1,2,3,4,5,6,7,8,9,10)
    val c = Array("home","about","career","home","cart","maps","home","home","about","career")
    print(mostVisitedPattern(a, b, c))
  }
}
