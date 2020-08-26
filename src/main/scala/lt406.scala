// https://leetcode.com/problems/queue-reconstruction-by-height/
object lt406 {
  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    if (people.length == 0) people
    else {
      var ans = List.empty[Array[Int]]
      val pp = people.sortBy(x => (-x(0), x(1)))
      pp.foreach(p => {
        val tmp = ans.splitAt(p(1))
        ans = tmp._1 ::: p :: tmp._2
      })
      ans.toArray
    }
  }
}
