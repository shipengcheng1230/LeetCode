object lt253 {
  def minMeetingRooms(intervals: Array[Array[Int]]): Int = {
    if (intervals.isEmpty) 0

    val timeBounds = intervals.foldLeft(List.empty[(Int, Boolean)])(
      (u, v) => (v.head, true) :: (v.last, false) :: u
    ).sortBy(e => (e._1, e._2))

    var count = 0
    timeBounds.foldLeft(0)(
      (acc, t) => {
        if (t._2) count += 1
        else count -= 1
        acc max count
      }
    )
  }
}
