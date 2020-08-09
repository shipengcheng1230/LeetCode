//https://leetcode.com/problems/minimum-window-subsequence/
object lt727 {
  import scala.annotation.tailrec

  def minWindow(S: String, T: String): String = {
    val M = Array.fill(S.length, T.length)(-1)
    S.indices.foreach(i => {
      if (S(i) == T.head) M(i)(0) = i
      else {
        if (i == 0) M(i)(0) = -1
        else M(i)(0) = M(i-1)(0)
      }
    })
    T.indices.tail.foreach(j => {
      S.indices.foreach(i => {
        if (S(i) == T(j)) {
          if (i == 0) M(i)(j) = -1
          else M(i)(j) = M(i-1)(j-1)
        } else {
          if (i == 0) M(i)(j) = -1
          else M(i)(j) = M(i-1)(j)
        }
      })
    })
    var start = 0
    var len = Integer.MAX_VALUE
    S.indices.foreach(i => {
      if (M(i)(T.length-1) != -1) {
        if (i - M(i)(T.length-1) + 1 < len) {
          len = i - M(i)(T.length-1) + 1
          start = M(i)(T.length - 1)
        }
      }
    })
    if (len == Integer.MAX_VALUE) "" else S.substring(start, start + len)
  }

  def main(args: Array[String]): Unit = {
    println(minWindow("cnhczmccqouqadqtmjjzl", "mm"))
    println(minWindow("abcdebdde", "bde"))
    println(minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "k"))
    println(minWindow("hpsrhgogezyfrwfrejytjkzvgpjnqil", "ggj"))
  }
}
