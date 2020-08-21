// https://leetcode.com/problems/exclusive-time-of-functions/
object lt636 {
  def exclusiveTime(n: Int, logs: List[String]): Array[Int] = {
    val stack = scala.collection.mutable.Stack.empty[Int]
    val ans = Array.fill(n)(0)
    var prev = 0 // previous timestamp
    logs.tail.foreach(log => {
      val s = log.split(":")
      if (s(1) == "start") {
        if (stack.nonEmpty)
          ans(stack.head) += s(2).toInt - prev

        prev = s(2).toInt
        stack.push(s(0).toInt)
      } else {
        ans(stack.head) += s(2).toInt - prev + 1
        stack.pop()
        prev = s(2).toInt + 1
      }
    })
    ans
  }
}
