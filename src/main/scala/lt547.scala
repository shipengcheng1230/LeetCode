// https://leetcode.com/problems/friend-circles/
object lt547 {
  def findCircleNum(M: Array[Array[Int]]): Int = {
    val seen = Array.fill(M.length)(false)

    def dfs(i: Int): Unit = {
      M.indices.foreach(j => {
        if (!seen(j) && M(i)(j) == 1) {
          seen(j) = true
          dfs(j)
        }
      })
    }

    var count = 0
    M.indices.foreach(i => {
      if (!seen(i)) {
        dfs(i)
        count += 1
      }
    })
    count
  }
}
