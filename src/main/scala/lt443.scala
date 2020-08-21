// https://leetcode.com/problems/string-compression/
object lt443 {
  def compress(chars: Array[Char]): Int = {
    var indexAns = 0
    var index = 0
    while (index < chars.length) {
      val c = chars(index)
      var count = 0
      while (index < chars.length && chars(index) == c) {
        index += 1
        count += 1
      }
      chars(indexAns) = c
      indexAns += 1
      if (count != 1) {
        // char array of count like `123`
        count.toString.foreach(x => {
          chars(indexAns) = x
          indexAns += 1
        })
      }
    }
    indexAns
  }
}
