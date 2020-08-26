// https://leetcode.com/problems/gas-station/
object lt134 {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    val total = gas.sum - cost.sum
    if (total < 0) -1
    else {
      var start = 0
      gas.indices.foldLeft(0)((acc, x) => {
        val remain = acc + gas(x) - cost(x)
        if (remain < 0) {
          start = x + 1
          0
        } else remain
      })
      start
    }
  }
}
