// https://leetcode.com/problems/encode-string-with-shortest-length/
object lt471 {
  def encode(s: String): String = {
    val n = s.length
    val dp = Array.ofDim[String](n, n)
    for (len <- 1 to n; i <- 0 to n - len) {
      val j = i + len - 1
      dp(i)(j) = s.substring(i, j + 1)
      for (k <- i until j) {
        val l = dp(i)(k)
        val r = dp(k + 1)(j)
        if (l.length + r.length < dp(i)(j).length)
          dp(i)(j) = l + r
      }
      val collapsed = collapse(dp, s.substring(i, i + len), i)
      if (collapsed.length < dp(i)(j).length)
        dp(i)(j) = collapsed
    }
    dp(0)(n - 1)
  }

  def collapse(dp: Array[Array[String]], str: String, i: Int): String = {
    val pos = (str + str).indexOf(str, 1)
    if (pos >= str.length) str
    else s"${str.length / pos}[${dp(i)(i + pos - 1)}]"
  }

  def main(args: Array[String]): Unit = {
    print(encode("abbbabbbcabbbabbbc"))
  }
}
