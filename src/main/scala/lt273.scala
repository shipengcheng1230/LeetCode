object lt273 {
  val under20 = Seq("Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
  val tens = Seq("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
  val thousands = Seq("", " Thousand", " Million", " Billion")

  def underK(num: Int): String = num match {
    case n if n < 20 => under20(n)
    case n if n < 100 => tens(n/10) + " " + recNumber(n % 10, 0)
    case n => recNumber(n / 100, 0) + " Hundred " + recNumber(n % 100, 0)
  }

  def recNumber(num:Int, tidx: Int): String = num match {
    case n if n == 0 => ""
    case n if n < 1000 => underK(n) + thousands(tidx)
    case n => recNumber(num / 1000, tidx+1) + " " + recNumber(num % 1000, tidx)
  }

  def numberToWords(num: Int): String = {
    if (num == 0) under20.head else recNumber(num, 0).trim.replaceAll(" +", " ")
  }

  def main(args: Array[String]): Unit = {
    print(numberToWords(12344))
  }
}
