// https://leetcode.com/problems/consecutive-numbers-sum/
object lt829 {
  def consecutiveNumbersSum(N: Int): Int = {
    var count = 0
    val upper = (math.sqrt(2 * N + 0.25) - 0.5).toInt
    (1 to upper).foreach(k => {
      if ((N - k * (k + 1) / 2) % k == 0) count += 1
    })
    count
  }
}
