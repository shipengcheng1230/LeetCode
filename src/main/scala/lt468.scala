// https://leetcode.com/problems/validate-ip-address/
object lt468 {
  def validIPAddress(IP: String): String = {

    def isValidIPv4Seg(s: String): Boolean = {
      if (s.length <= 3)
        if (s.length == 1 || s.length > 1 && s.head != '0') {
          if (s.forall(_.isDigit))
            if (s.toInt <= 255)
              return true
        }
      false
    }

    def isValidIpv6Seg(s: String): Boolean = {
      if (s.length <= 4)
        if (s.forall(c => c.isDigit || c.toLower <= 'f' && c.toLower >= 'a'))
          return true
      false
    }
    val s4 = IP.split("\\.").filter(_.nonEmpty)
    val s6 = IP.split(":").filter(_.nonEmpty)
    if (IP.count(_ == '.') == 3 && s4.length == 4 && s4.forall(isValidIPv4Seg)) "IPv4"
    else if (IP.count(_ == ':') == 7 && s6.length == 8 && s6.forall(isValidIpv6Seg)) "IPv6"
    else "Neither"
  }

  def main(args: Array[String]): Unit = {
    println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"))
  }
}
