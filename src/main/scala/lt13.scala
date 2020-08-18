// https://leetcode.com/problems/roman-to-integer/
object lt13 {

  val dict: Map[Char, Int] = Map(
    'I' -> 1,
    'V' -> 5,
    'X' -> 10,
    'L' -> 50,
    'C' -> 100,
    'D' -> 500,
    'M' -> 1000
  )

  def romanToInt(s: Seq[Char]): Int = s match {
    case Seq(a, b, t @_*) if dict(a) < dict(b) => dict(b) - dict(a) + romanToInt(t)
    case Seq(a, t @_*) => dict(a) + romanToInt(t)
    case _ => 0
  }
}
