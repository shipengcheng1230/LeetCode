// https://leetcode.com/problems/restore-ip-addresses/
object lt93 {
  def restoreIpAddresses(s: String): List[String] = {
    import scala.collection.mutable.ListBuffer

    val ans = ListBuffer.empty[String]

    def dfs(index: Int, remain: Int, path: List[String]): Unit = {
      if (remain == 0) {
        if (s.length == index) ans.append(path.reverse.mkString("."))
      } else {
        if (index <= s.length) {
          val ns =
            (1 to 3)
              .map(i => s.slice(index, index + i))
              .filterNot(x => x.length == 0 || (x.length > 1 && x.head == '0'))
              .filter(x => x.toInt <= 255)

          ns.foreach(str => dfs(index + str.length, remain - 1, str :: path))
        }
      }
    }

    dfs(0, 4, List())
    ans.toList.distinct
  }

  def main(args: Array[String]): Unit = {
    println(restoreIpAddresses("25525511135"))
  }
}
