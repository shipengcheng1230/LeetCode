// https://leetcode.com/problems/optimal-account-balancing/
object lt465 {
  def minTransfers(transactions: Array[Array[Int]]): Int = {
    val m = scala.collection.mutable.Map.empty[Int, Int]
    transactions.foreach(t => {
      m.update(t(0), m.getOrElse(t(0), 0) - t(2))
      m.update(t(1), m.getOrElse(t(1), 0) + t(2))
    })
    val debts = m.values.toArray

    def settle(start: Int): Int = {
      var cur = start
      while (cur < debts.length && debts(cur) == 0)
        cur += 1
      if (cur == debts.length) 0
      else {
        var r = Int.MaxValue
        (cur + 1 until debts.length).foreach(i => {
          if (debts(cur) * debts(i) < 0) {
            debts(i) = debts(i) + debts(cur)
            r = r min (1 + settle(cur + 1))
            debts(i) = debts(i) - debts(cur)
          }
        })
        r
      }
    }

    settle(0)
  }
}
