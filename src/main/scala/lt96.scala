// https://leetcode.com/problems/unique-binary-search-trees/
object lt96 {
  def numTrees(n: Int): Int = {
    val G = Array.fill(n + 1)(0)
    G(0) = 1
    G(1) = 1
    for {
      i <- 2 to n
      j <- 1 to i
    } {
      G(i) += G(j - 1) * G(i - j)
    }
    G(n)
  }
}
