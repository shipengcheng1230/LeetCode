object lt420 {
  def strongPasswordChecker(s: String): Int = {
    var missing_type = 3
    if (s.exists(_.isLower)) missing_type -= 1
    if (s.exists(_.isUpper)) missing_type -= 1
    if (s.exists(_.isDigit)) missing_type -= 1

    var change = 0
    var one = 0
    var two = 0
    var p = 2

    while (p < s.length) {
      if (s(p) == s(p-1) && s(p-1)== s(p-2)) {
        var length = 2
        while (p < s.length && s(p) == s(p-1)) {
          length += 1
          p += 1
        }
        change += length / 3
        if (length % 3 == 0) one += 1
        if (length % 3 == 1) two += 1
      } else
        p += 1
    }

    if (s.length < 6) missing_type max (6 - s.length)
    else if (s.length <= 20) missing_type max change
    else {
      val delete = s.length - 20
      change -= delete min one
      change -= math.min(math.max(delete - one, 0), two * 2) / 2
      change -= math.max(delete - one - 2 * two, 0) / 3
      delete + (missing_type max change)
    }
  }

  def main(args: Array[String]): Unit = {
    println(strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa"))
  }
}
