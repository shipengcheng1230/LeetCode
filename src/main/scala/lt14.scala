// https://leetcode.com/problems/longest-common-prefix/
object lt14 {
  def longestCommonPrefix(strs: Array[String]): String = {

    def common(s1: String, s2: String): String = {
      s1.zip(s2).foldLeft("")((acc, x) => if (x._1 == x._2) acc + x._1 else return acc)
    }

    def longestCommonPrefix(strs: Array[String], l: Int, r: Int): String = {
      if (l == r) strs(l)
      else {
        val mid = (l + r) / 2
        val s1 = longestCommonPrefix(strs, l ,mid)
        val s2 = longestCommonPrefix(strs, mid + 1, r)
        common(s1, s2)
      }
    }

    if (strs.isEmpty) "" else longestCommonPrefix(strs, 0, strs.length - 1)
  }

  def main(args: Array[String]): Unit = {
    print(longestCommonPrefix(Array("flower","flow","flight")))
  }
}
