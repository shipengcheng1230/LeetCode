//https://leetcode.com/problems/open-the-lock/
object lt752 {
  def openLock(deadends: Array[String], target: String): Int = {
    import scala.collection.mutable

    val q = mutable.Queue.empty[String]
    val seen = mutable.Set.empty[String]
    q.enqueue("0000")
    seen.add("0000")
    var depth = 0

    while (q.nonEmpty) {
      q.dequeueAll(_ => true).foreach(n => {
        if (n == target) return depth
        else {
          if (!deadends.contains(n)) {
            (0 until 4).foreach(i => {
              List(-1, 1).foreach(up => {
                val x = (n.charAt(i).asDigit + up + 10) % 10
                val nbr = n.substring(0, i) + s"${x}" + n.substring(i+1)
                if (!seen.contains(nbr)) {
                  seen.add(nbr)
                  q.enqueue(nbr)
                }
              })
            })
          }
        }
      })
      depth += 1
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    println(openLock(Array("0201","0101","0102","1212","2002"), "0202"))
  }
}
