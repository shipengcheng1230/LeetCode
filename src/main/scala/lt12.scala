// https://leetcode.com/problems/integer-to-roman/
object lt12 {
  val values = Vector(1000,900,500,400,100,90,50,40,10,9,5,4,1)
  val symbols = Vector("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I")

  def intToRoman(num: Int): String = {
    val sb = new StringBuilder
    var n = num
    values.indices.foreach(i => {
      while (values(i) <= n) {
        n -= values(i)
        sb.append(symbols(i))
      }
    })
    sb.toString()
  }
}
