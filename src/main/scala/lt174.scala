// https://leetcode.com/problems/dungeon-game/
object lt174 {
  def calculateMinimumHP(dungeon: Array[Array[Int]]): Int = {
    val rows = dungeon.length
    val cols = dungeon.head.length
    val dp = Array.fill(rows, cols)(Int.MaxValue)

    def getMinHealth(curr: Int, r: Int, c: Int): Int = {
      if (r >= rows || c >= cols) Int.MaxValue
      else math.max(1, dp(r)(c) - curr)
    }

    for {
      row <- rows - 1 to 0 by -1
      col <- cols - 1 to 0 by -1
    } {
      val curr = dungeon(row)(col)
      val right = getMinHealth(curr, row, col + 1)
      val down = getMinHealth(curr, row + 1, col)
      val next = right min down

      val min = if (next != Int.MaxValue) next
      else {
        if (curr >= 0) 1 else 1 - curr
      }
      dp(row)(col) = min
    }
    dp(0)(0)
  }
}
