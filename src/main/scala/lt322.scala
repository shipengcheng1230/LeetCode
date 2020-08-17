// https://leetcode.com/problems/coin-change/
object lt322 {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val memo = scala.collection.mutable.Map.empty[Int, Int]
    coins.sortInPlace()(Ordering[Int].reverse)

    def helper(left: Int): Int = {
      if (left < 0) -1
      else if (left == 0) 0
      else {
        memo.getOrElseUpdate(left, {
          val ans = coins.reverse.map(x => helper(left - x) + 1).filter(_ > 0)
          if (ans.isEmpty) -1 else ans.min
        })
      }
    }

    helper(amount)
  }

  def main(args: Array[String]): Unit = {
    println(coinChange(Array(186,419,83,408), 6249))
  }
}
