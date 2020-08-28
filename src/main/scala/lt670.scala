// https://leetcode.com/problems/maximum-swap/
object lt670 {
  def maximumSwap(num: Int): Int = {
    val digits = num.toString.map(_.asDigit).toArray
    val last = Array.fill(10)(-1)
    digits.zipWithIndex.foreach(x => last(x._1) = x._2)
    digits.indices.foreach(i => {
      (9 until digits(i) by -1).foreach(d => {
        if (last(d) > i) {
          val tmp = digits(i)
          digits(i) = d
          digits(last(d)) = tmp
          return digits.foldLeft(0)(_ * 10 + _)
        }
      })
    })
    num
  }

  def main(args: Array[String]): Unit = {
    println(maximumSwap(10))
  }
}
