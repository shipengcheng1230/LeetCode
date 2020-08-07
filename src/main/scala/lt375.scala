object lt375 {
  def getMoneyAmount(n: Int): Int = {
    val dp = Array.fill(n+1, n+1)(0)

    def getMoneyAmount(lower: Int, upper: Int): Int = {
      if (lower >= upper) 0
      else if (dp(lower)(upper) != 0) dp(lower)(upper)
      else {
        var curmax = Integer.MAX_VALUE
        (lower to upper).foreach(i => {
          curmax = curmax min ((getMoneyAmount(lower, i-1) max getMoneyAmount(i+1, upper)) + i)
        })
        dp(lower)(upper) = curmax
        curmax
      }
    }

    getMoneyAmount(1, n)
  }
}
