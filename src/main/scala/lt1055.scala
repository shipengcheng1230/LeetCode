// https://leetcode.com/problems/shortest-way-to-form-string/
object lt1055 {
  def shortestWay(source: String, target: String): Int = {
    val map = Array.fill(26)(false)
    source.indices.foreach(i => map(source(i) - 'a') = true)
    var j = 0
    var i = 0
    var res = 1
    while (i < target.length) {
      if (!map(target(i) - 'a')) return -1
      while (j < source.length && source(j) != target(i)) j += 1
      if (j == source.length) {
        j = 0
        res += 1
      } else {
        i += 1
        j += 1
      }
    }
    res
  }
}
