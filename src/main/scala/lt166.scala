// https://leetcode.com/problems/fraction-to-recurring-decimal/
object lt166 {
  def fractionToDecimal(numerator: Int, denominator: Int): String = {
    if (denominator == 0 || numerator == 0) return "0"
    val ans = new StringBuilder
    if (numerator < 0 ^ denominator < 0)
      ans.addOne('-')

    val dividened = math.abs(numerator.toLong)
    val divisor = math.abs(denominator.toLong)
    ans.append(dividened / divisor)
    var remainder = dividened % divisor
    if (remainder == 0)
      return ans.toString()

    ans.addOne('.')
    val map = scala.collection.mutable.Map.empty[Long, Int]
    while (remainder != 0) {
      if (map.contains(remainder)) {
        ans.insert(map(remainder), '(')
        ans.addOne(')')
        return ans.toString()
      }
      map.update(remainder, ans.length())
      remainder *= 10
      ans.append((remainder / divisor).toString)
      remainder %= divisor
    }
    ans.toString()
  }
}
