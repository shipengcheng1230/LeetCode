object lt359 {
  class Logger() {

    /** Initialize your data structure here. */
    import scala.collection.mutable.Map

    val memo = Map.empty[String, Int]

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
      If this method returns false, the message will not be printed.
      The timestamp is in seconds granularity. */
    def shouldPrintMessage(timestamp: Int, message: String): Boolean = {
      val lastTime = memo.getOrElseUpdate(message, -1)
      if (lastTime == -1 || (timestamp - lastTime) >= 10) {
        memo.update(message, timestamp)
        true
      } else false
    }

  }

}
