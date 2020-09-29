// https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/
object lt1601 {
  def maximumRequests(n: Int, requests: Array[Array[Int]]): Int = {
    val nr = requests.length

    def backtrack(mask: Int): Int = {
      val degree = Array.fill(n)(0)

      for (i <- 0 until nr; if ((1 << i) & mask) != 0) {
        degree(requests(i)(0)) -= 1
        degree(requests(i)(1)) += 1
      }
      if (degree.forall(_ == 0)) mask.toBinaryString.count(_ == '1') else 0
    }

    (0 until 1 << nr).map(backtrack).max
  }
}
