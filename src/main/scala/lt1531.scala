// https://leetcode.com/problems/string-compression-ii/
object lt1531 {
  def getLengthOfOptimalCompression(s: String, k: Int): Int = {
    val n = s.length
    val dp = Array.fill(110, 110)(9999)
    dp(0)(0) = 0
    for (i <- 1 to n; j <- 0 to k) {
      var cnt = 0
      var del = 0
      for (l <- i to 1 by -1) { // keep s(i), concat the same, delete the different
        if (s(l - 1) == s(i - 1)) cnt += 1 else del += 1
        if (j - del >= 0)
          dp(i)(j) = dp(i)(j) min (dp(l - 1)(j - del) + 1 + (
            if (cnt >= 100) 3 else if (cnt >= 10) 2 else if (cnt >= 2) 1 else 0
          ))
      }
      if (j > 0) // delete s(i)
        dp(i)(j) = dp(i)(j) min dp(i - 1)(j - 1)
    }
    dp(n)(k)
  }

  def main(args: Array[String]): Unit = {
    println(getLengthOfOptimalCompression("aaabcccd", 2))
  }
}
