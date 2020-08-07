object lt57 {
  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {

    intervals.foldLeft(Array(newInterval))((acc ,x) => {
      val last = acc.last
      if (last(1) < x(0)) acc.appended(x)
      else if (last(0) > x(1)) acc.init.appended(x).appended(last)
      else acc.init.appended(Array(last(0) min x(0), last(1) max x(1)))
    })
  }
}
