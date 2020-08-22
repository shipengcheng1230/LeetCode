// https://leetcode.com/problems/coin-change-2/
object lt518 {
  def change(amount: Int, coins: Array[Int]): Int = {
    val dp = Array.fill(amount + 1)(0)
    dp(0) = 1
    coins.foreach(coin => {
      (coin to amount).foreach(x => dp(x) += dp(x - coin))
    })
    dp(amount)
  }
}
