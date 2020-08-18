// https://leetcode.com/problems/employee-free-time/
object lt759 {

  class Interval(var _start: Int, var _end: Int) {
    var start: Int = _start
    var end: Int = _end
  }

  def employeeFreeTime(schedule: List[List[Interval]]): List[Interval] = {
    import scala.collection.mutable

    val events = mutable.ArrayBuffer.empty[(Int, Int)]
    schedule.flatten.foreach(x => {
      events.addOne((x.start, 0))
      events.addOne((x.`end`, 1))
    })
    events.sortInPlace()
    val ans = mutable.ListBuffer.empty[Interval]
    var prev = -1
    var bal = 0
    events.foreach(event => {
      if (bal == 0 && prev >= 0) ans.append(new Interval(prev, event._1))
      if (event._2 == 0) bal += 1 else bal -= 1
      prev = event._1
    })
    ans.toList
  }
}
