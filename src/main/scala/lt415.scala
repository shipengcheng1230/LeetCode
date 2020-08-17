// https://leetcode.com/problems/add-strings/
object lt415 {
  def addStrings(num1: String, num2: String): String = {
    val ans = num1.reverse.zipAll(num2.reverse, '0', '0').foldLeft((List.empty[Char], 0))(op = (acc, x) => {
      val y = x._1.asDigit + x._2.asDigit + acc._2
      ((y % 10 + '0').toChar :: acc._1, y / 10)
    })

    val res = if (ans._2 == 0) ans._1 else ans._2 :: ans._1
    res.mkString("")
  }

  def main(args: Array[String]): Unit = {
    println(addStrings("6913259244", "71103343"))
  }
}
