// https://leetcode.com/problems/task-scheduler/
object lt621 {
  def leastInterval(tasks: Array[Char], n: Int): Int = {
    val frequency = Array.fill(26)(0)
    tasks.foreach(c => frequency(c - 'A') += 1)
    frequency.sortInPlace()
    val maxFreq = frequency.last
    var idleTime = (maxFreq - 1) * n
    for (i <- frequency.length - 2 to 0 by -1; if idleTime > 0) {
      idleTime -= math.min(maxFreq - 1, frequency(i))
    }
    idleTime = 0 max idleTime
    tasks.length + idleTime
  }
}
