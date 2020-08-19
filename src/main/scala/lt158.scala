// https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
object lt158 {
  def read4(buf4: Array[Char]): Int = ???

  import scala.util.control.Breaks._

  val buf4: Array[Char] = Array.fill[Char](4)('0')
  var i4 = 0
  var n4 = 0

  def read(buf: Array[Char], n: Int): Int = {
    var i = 0
    breakable {
      while (i < n) {
        if (i4 > n4) {
          i4 = 0
          n4 = read4(buf4)
          if (n4 == 0) break()
        }
        buf(i) = buf4(i4)
        i += 1
        i4 += 1

      }
    }
    i
  }
}
