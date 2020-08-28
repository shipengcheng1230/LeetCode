// https://leetcode.com/problems/multiply-strings/
object lt43 {
  def multiply(num1: String, num2: String): String = {
    val m = num1.length
    val n = num2.length
    val pos = Array.fill(m + n)(0)
    for  {
      i <- m - 1 to 0 by -1
      j <- n - 1 to 0 by -1
    } {
      val mul = num1(i).asDigit * num2(j).asDigit
      val p1 = i + j
      val p2 = p1 + 1
      val sum = pos(p2) + mul
      pos(p1) += sum / 10
      pos(p2) = sum % 10
    }
    val ans = pos.dropWhile(_ == 0).mkString("")
    if (ans.isEmpty) "0" else ans
  }
}
