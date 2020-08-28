// https://leetcode.com/problems/expression-add-operators/
object lt282 {
  def addOperators(num: String, target: Int): List[String] = {
    import scala.collection.mutable

    val ans = mutable.ListBuffer.empty[String]

    def helper(path: String, pos: Int, eval: Long, prev: Long): Unit = {
      if (pos == num.length) {
        if (target == eval)
          ans.addOne(path)
        return
      }

      for { i <- pos until num.length } {
        if (i != pos && num(pos) == '0') return
        val cur = num.substring(pos, i + 1).toLong
        if (pos == 0)
          helper(path + cur, i + 1, eval + cur, cur)
        else {
          helper(path + "+" + cur, i + 1, eval + cur, cur)
          helper(path + "-" + cur, i + 1, eval - cur, -cur)
          helper(path + "*" + cur, i + 1, eval - prev + prev * cur, prev * cur)
        }
      }
    }

    helper("", 0, 0, 0)
    ans.toList
  }

  def main(args: Array[String]): Unit = {
    println(addOperators("105", 5))
  }
}
