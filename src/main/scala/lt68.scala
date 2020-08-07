import scala.annotation.tailrec

object lt68 {

  case class LineString(strs: List[String], maxWidth: Int = 1) {
    def chrs: Int = strs.map(_.length).sum
    def width: Int = chrs + strs.length - 1
    def canMerge(that: LineString): Boolean = width + 1 + that.width <= maxWidth
    def + (that: LineString): LineString = LineString(strs ::: that.strs, maxWidth)
    @tailrec
    final def prettyHelper(s: String, remain: Int, acc: List[String]): String = acc match {
      case Nil => ""
      case h :: Nil => s + " " * (maxWidth - s.length - h.length) + h
      case _ :: t =>
        val nws = math.ceil(remain.toDouble / t.length).toInt
        prettyHelper(s + acc.head + " " * nws, remain - nws, acc.tail)
    }
    def pretty: String = if (strs.length == 1) leftJustify else prettyHelper("", maxWidth - chrs, strs)
    def leftJustify: String = {
      val ret = strs.mkString(" ")
      ret + " " * (maxWidth - ret.length)
    }
  }

  def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
    val ss = words.foldLeft(List.empty[LineString])((acc, x) => {
      val ns = LineString(List(x), maxWidth)
      if (acc.isEmpty) ns :: acc
      else if (acc.head.canMerge(ns)) (acc.head + ns) :: acc.tail
      else ns :: acc
    })
    (ss.head.leftJustify :: ss.tail.map(_.pretty)).reverse
  }

  def main(args: Array[String]): Unit = {
//    val x = Array("Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do")
    val x = Array("What","must","be","acknowledgment","shall","be")
    fullJustify(x, 16).foreach(x => println(x))
  }
}
