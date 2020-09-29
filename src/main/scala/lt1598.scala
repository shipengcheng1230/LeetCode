// https://leetcode.com/problems/crawler-log-folder/
object lt1598 {
  def minOperations(logs: Array[String]): Int = {
    var depth = 0
    logs.foreach(log => {
      if (log.startsWith("../")) depth = 0 max (depth - 1)
      if (log.head.isLetter) depth += 1
    })
    depth
  }
}
