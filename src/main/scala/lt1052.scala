// https://leetcode.com/problems/grumpy-bookstore-owner/
object lt1052 {
  def maxSatisfied(customers: Array[Int], grumpy: Array[Int], X: Int): Int = {
    var satisfied = 0
    var maxMakeSatisfied = 0
    var winofMakeSatisfied = 0
    for (i <- grumpy.indices) {
      if (grumpy(i) == 0) satisfied += customers(i)
      else winofMakeSatisfied += customers(i)

      if (i >= X) winofMakeSatisfied -= grumpy(i - X) * customers(i - X)
      maxMakeSatisfied = maxMakeSatisfied max winofMakeSatisfied
    }
    satisfied + maxMakeSatisfied
  }
}
