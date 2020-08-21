// https://leetcode.com/problems/maximum-profit-in-job-scheduling/
object lt1235 {
  def jobScheduling(startTime: Array[Int], endTime: Array[Int], profit: Array[Int]): Int = {
    val n = startTime.length
    val jobs = (0 until n)
      .map(i => (startTime(i), endTime(i), profit(i)))
      .sortBy(_._2)
    val dp = scala.collection.mutable.TreeMap.empty[Int, Int]
    dp.update(0, 0)
    jobs.foreach(job => {
      val cur = dp.rangeTo(job._1).last._2 + job._3
      if (cur > dp.last._2)
        dp.update(job._2, cur)
    })
    dp.last._2
  }
}
