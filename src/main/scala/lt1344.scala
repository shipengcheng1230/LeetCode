// https://leetcode.com/problems/angle-between-hands-of-a-clock/
object lt1344 {
  def angleClock(hour: Int, minutes: Int): Double = {
    val h = (hour + minutes / 60.0) * 30
    val m = minutes * 6
    val diff = math.abs(h - m)
    (360 - diff) min diff
  }
}
