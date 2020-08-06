object l56 {
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    val x = intervals.sortBy(_(0))
    x.foldLeft(Array[Array[Int]]())((a, b) => {
      if (a.length == 0) Array(b)
      else {
        if (a.last(1) >= b(0)) a.init :+ Array(a.last(0), a.last(1) max b(1))
        else a :+ b
      }
    })
  }
}