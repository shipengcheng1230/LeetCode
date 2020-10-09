// https://leetcode.com/problems/knight-probability-in-chessboard/submissions/
object lt688 {
  def knightProbability(N: Int, K: Int, sr: Int, sc: Int): Double = {
    var prev = Array.fill(N, N)(0.0)
    prev(sr)(sc) = 1.0
    val directions = List((1,2), (1,-2), (-1,2), (-1,-2), (2,1), (2,-1), (-2,1), (-2,-1))
    for (_ <- 1 to K) {
      val dp = Array.fill(N, N)(0.0)
      for {
        r <- 0 until N
        c <- 0 until N
        d <- directions
      } {
        val nr = r + d._1
        val nc = c + d._2
        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
          dp(nr)(nc) += prev(r)(c) / 8.0
        }
      }
      prev = dp
    }
    prev.map(_.sum).sum
  }
}
